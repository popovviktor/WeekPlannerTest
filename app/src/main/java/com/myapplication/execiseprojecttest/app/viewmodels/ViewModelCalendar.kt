package com.myapplication.execiseprojecttest.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapplication.execiseprojecttest.data.api.models.Execise
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class ViewModelCalendar @Inject constructor():ViewModel() {
    private val mSelectors = MutableLiveData<ArrayList<Boolean>>()
    val selectors:LiveData<ArrayList<Boolean>> = mSelectors
    private val _allNameExecises = MutableLiveData<ArrayList<String>>()
    val allNameExecises:LiveData<ArrayList<String>> = _allNameExecises
    private val _execisesAll = MutableLiveData<ArrayList<Execise>>()
    val execisesAll:LiveData<ArrayList<Execise>> = _execisesAll

    private val _execisesToday = MutableLiveData<ArrayList<Execise>>()
    val execisesToday:LiveData<ArrayList<Execise>> = _execisesToday

    private val _execisesCompleted = MutableLiveData<ArrayList<Execise>>()
    val execisesCompleted:LiveData<ArrayList<Execise>> = _execisesCompleted

    private val _execisesThisWeek = MutableLiveData<ArrayList<Execise>>()
    val execisesThisWeek:LiveData<ArrayList<Execise>> = _execisesThisWeek

    private val _execisesNextWeek = MutableLiveData<ArrayList<Execise>>()
    val execisesNextWeek:LiveData<ArrayList<Execise>> = _execisesNextWeek

    private val _digitsAllday = MutableLiveData<ArrayList<Int>>()
    val digitsAllday: LiveData<ArrayList<Int>>
        get() = _digitsAllday
    private val _digitToday = MutableLiveData<Int>()
    val digitToday:LiveData<Int> = _digitToday

    private val _digitsThisWeek = MutableLiveData<ArrayList<Int>>()
    val digitsThisWeek:LiveData<ArrayList<Int>> = _digitsThisWeek

    private val _digitsNextWeek = MutableLiveData<ArrayList<Int>>()
    val digitsNextWeek:LiveData<ArrayList<Int>> = _digitsNextWeek
    init {
        initThisDAy()
    }
    fun setDigitsThisWeek(){
        var arrThisWeek =ArrayList<Int>()
        for (elem in 0..6){
            arrThisWeek.add(_digitsAllday.value!!.get(elem))
        }
        _digitsThisWeek.value = arrThisWeek
    }
    fun setDigitsNextWeek(){
        var arrNextWeek =ArrayList<Int>()
        for (elem in 7..13){
            arrNextWeek.add(_digitsAllday.value!!.get(elem))
        }
        _digitsNextWeek.value = arrNextWeek
    }
    fun initThisDAy(){
        val calendar = Calendar.getInstance()
        val intdayofmonth = calendar.get(Calendar.DAY_OF_MONTH)
        _digitToday.value = intdayofmonth
    }
    fun setDigitsAllDAy(arr:ArrayList<Int>){
        _digitsAllday.value = arr
    }
    fun setExecisesAll(arr:ArrayList<Execise>){
        _execisesAll.value = arr
    }
    fun setSelectors(){
        var arrBools = ArrayList<Boolean>()
        for (elem in 0.._execisesAll.value!!.size-1){
            arrBools.add(false)
        }
        mSelectors.value = arrBools
    }
    fun setAllNamesExis(){
        var strNameExecises = ArrayList<String>()
        for (elem in _execisesAll.value!!){
            strNameExecises.add(elem.name.toString())
        }
        _allNameExecises.value = strNameExecises
    }
    fun setThisExeciseComplete(nameExecise:String){
        var oldSelector = mSelectors.value!!
        var index = _allNameExecises.value?.indexOf(nameExecise)!!
        oldSelector.set(index,true)
        mSelectors.value = oldSelector
        System.out.println(mSelectors.value)
    }
    fun funvisibleButton(nameExecise:String):Boolean{
        var index = _allNameExecises.value?.indexOf(nameExecise)!!
        var result = mSelectors.value?.get(index)!!
        return result
    }
    fun fundataForTodayAdapter():ArrayList<Execise>{
        var arrToday = ArrayList<Execise>()
        for (elem in _execisesAll.value!!){
            if (elem.date == _digitToday.value.toString()){
                var index = _execisesAll.value!!.indexOf(elem)
                if (!selectors.value!!.get(index)){
                    arrToday.add(elem)
                }
            }
        }
        _execisesToday.value = arrToday
        return arrToday
    }
    fun fundataForThisWeekAdapter(){
        var arrThisWeek = ArrayList<Execise>()
        for (elem in _execisesAll.value!!){
            for (elemDigit in _digitsThisWeek.value!!){
                if (elem.date == elemDigit.toString()&& elemDigit!=_digitToday.value!!){
                    var index = _execisesAll.value!!.indexOf(elem)
                    if (!selectors.value!!.get(index)){
                        arrThisWeek.add(elem)
                    }
                }
            }
        }
        _execisesThisWeek.value = arrThisWeek
    }
    fun fundataForNextWeekAdapter(){
        var arrNextWeek = ArrayList<Execise>()
        for (elem in _execisesAll.value!!){
            for (elemDigit in _digitsNextWeek.value!!){
                if (elem.date == elemDigit.toString()){
                    var index = _execisesAll.value!!.indexOf(elem)
                    if (!selectors.value!!.get(index)){
                        arrNextWeek.add(elem)
                    }
                }
            }
        }
        _execisesNextWeek.value = arrNextWeek
    }
    fun fundataForCompleted(){
        var arrComleted = ArrayList<Execise>()
        for (elem in _execisesAll.value!!){
            var index = _execisesAll.value!!.indexOf(elem)
            if (selectors.value!!.get(index)){
                arrComleted.add(elem)
            }
        }
        _execisesCompleted.value = arrComleted
    }

}