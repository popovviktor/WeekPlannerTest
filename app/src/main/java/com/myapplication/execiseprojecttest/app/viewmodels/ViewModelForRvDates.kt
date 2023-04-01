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
class ViewModelForRvDates @Inject constructor():ViewModel() {
    private val _digitsAllday = MutableLiveData<ArrayList<Int>>()
    val digitsAllday: LiveData<ArrayList<Int>>
        get() = _digitsAllday
    private val _dayOfWeek = MutableLiveData<ArrayList<String>>()
    val dayOfWeek:LiveData<ArrayList<String>>
        get() = _dayOfWeek
    private val _selecteditems = MutableLiveData<ArrayList<Boolean>>()
    val selecteditems:LiveData<ArrayList<Boolean>>
        get() = _selecteditems
    private val _colorsback = MutableLiveData<ArrayList<String>>()
    val colorsback:LiveData<ArrayList<String>>
        get() = _colorsback

    fun insertcolorsback(execises:ArrayList<Execise>){
        var arrDateEx = ArrayList<String>()
        for (elem in execises!!){
            arrDateEx.add(elem.date.toString())
        }
        var colors = ArrayList<String>()
        for (elem in _digitsAllday.value!!){
                if (digitinExecise(arrDateEx,elem)){
                    colors.add("#464B54")
                }else{colors.add("#282C31")}
        }
        _colorsback.value = colors
    }
    fun digitinExecise(strDaysExecise:ArrayList<String>,digit:Int):Boolean{
        for (elem in strDaysExecise){
            if (elem.equals(digit.toString())){
                return true
            }
        }
    return false}
    init {
        searchDigitsAllday()
        initDaysOfWeek()
        initSelected()
    }
    fun initwithoutThisDaySelected(){
        val arrBool = arrayListOf<Boolean>(false,false,false,false,false,false,false,
            false,false,false,false,false,false,false)
        _selecteditems.value = arrBool
    }
    fun initSelected(){
        val calendar = Calendar.getInstance()
        val arrBool = arrayListOf<Boolean>(false,false,false,false,false,false,false,
            false,false,false,false,false,false,false)
        val intthisday = calendar.get(Calendar.DAY_OF_MONTH)
        var index = _digitsAllday.value?.indexOf(intthisday)!!
        arrBool.set(index,true)
        _selecteditems.value = arrBool
    }
    private fun initDaysOfWeek(){
        val arrStr = arrayListOf<String>("MON","TUE","WED","THU","FRI","SAT","SUN",
            "MON","TUE","WED","THU","FRI","SAT","SUN")
        _dayOfWeek.value = arrStr
    }
    private fun searchDigitsAllday(){
        val calendar = Calendar.getInstance()
        val intdayofweek = calendar.get(Calendar.DAY_OF_WEEK)
        val allday = ArrayList<Int>()
        when(intdayofweek){
            1->{allday.addAll(dayofweekOne())}
            2->{allday.addAll(dayofweekTwo())}
            3->{allday.addAll(dayofWeekThree())}
            4->{allday.addAll(dayofWeekFour())}
            5->{allday.addAll(dayofWeekFive())}
            6->{allday.addAll(dayofWeekSix())}
            7->{allday.addAll(dayofWeekSeven())}
        }
        _digitsAllday.value= allday
    }
    fun findIndexDigitInAllDigit(digit: Int):Int{
        return _digitsAllday.value?.indexOf(digit)!!
    }

    private fun findDigitDayOfMonth(find: Int):Int{
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE,find)
        return calendar.get(Calendar.DAY_OF_MONTH)
    }
    fun dayofweekOne():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -6..7){
            arrdayes.add(findDigitDayOfMonth(elem))
        }
        return arrdayes
    }
    fun dayofweekTwo():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in 0..13){
            arrdayes.add(findDigitDayOfMonth(elem))
        }
        return arrdayes
    }
    fun dayofWeekThree():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -1..12){
            arrdayes.add(findDigitDayOfMonth(elem)) }
        return arrdayes
    }

    fun dayofWeekFour():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -2..11){
            arrdayes.add(findDigitDayOfMonth(elem)) }
        return arrdayes
    }
    fun dayofWeekFive():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -3..10){
            arrdayes.add(findDigitDayOfMonth(elem)) }
        return arrdayes
    }
    fun dayofWeekSix():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -4..9){
            arrdayes.add(findDigitDayOfMonth(elem)) }
        return arrdayes
    }
    fun dayofWeekSeven():ArrayList<Int>{
        val arrdayes = ArrayList<Int>()
        for (elem in -5..8){
            arrdayes.add(findDigitDayOfMonth(elem)) }
        return arrdayes
    }
}