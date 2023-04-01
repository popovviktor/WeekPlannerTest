package com.myapplication.execiseprojecttest.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapplication.execiseprojecttest.data.api.models.Execise
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ViewModelHomeExecise @Inject constructor():ViewModel() {

    private val mAllExecises = MutableLiveData<ArrayList<Execise>>()
    val allExecises:LiveData<ArrayList<Execise>> = mAllExecises
    fun setAllExecises(execises: ArrayList<Execise>){
        mAllExecises.value = execises
    }
    private val mLiveExecises = MutableLiveData<ArrayList<Execise>>()
    val execisesLive:LiveData<ArrayList<Execise>> = mLiveExecises


    fun findExecies(execises: ArrayList<Execise>){
        var arrexecises = ArrayList<Execise>()
        for (elem in execises){
            if (elem.date==(_intDay.value.toString())){
                arrexecises.add(elem)
            }
        }
        mLiveExecises.value = arrexecises
    }
    fun namesExecises():ArrayList<String>{
        var strNameExecises = ArrayList<String>()
        for (elem in mLiveExecises.value!!){
            strNameExecises.add(elem.name.toString())
        }
        return strNameExecises
    }

    private val _intDay = MutableLiveData<Int>()
    val intday:LiveData<Int>
            get() =  _intDay
    init {
        initday()
    }
    fun initday (){
        _intDay.value = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }
    fun setintDay(day:Int){
        _intDay.value = day
    }
}