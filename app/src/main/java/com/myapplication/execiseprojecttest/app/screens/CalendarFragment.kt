package com.myapplication.execiseprojecttest.app.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelCalendar
import com.myapplication.execiseprojecttest.app.screens.calendarcreens.*
import com.myapplication.execiseprojecttest.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {
    lateinit var binding:FragmentCalendarBinding
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCalendarHeader()
        initParamsInsertFramelayout()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
       @JvmStatic
        fun newInstance() = CalendarFragment()
    }
    fun initCalendarHeader(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.frameHeader, HeaderCalendarFragment())
            ?.commit()
    }
    fun initParamsInsertFramelayout(){
        if(vmcalendar.execisesToday.value?.size!!<1){
            if (vmcalendar.execisesThisWeek.value?.size!!<1){
                startFragmentCompleteOne()
                startFragmentWithNextWeekTwo()
            }else{
                startFragmentWithThisWeekOne()
                startFragmentDoneTwo()
            }
        }else {
            startFragmentWithToDayOne()
            if (vmcalendar.execisesThisWeek.value?.size!!>0){
                startFragmentWithThisWeekTwo()
                if (vmcalendar.execisesCompleted.value?.size!!>0){
                    startFragmentDoneThree()
                }
            }else{
                if (vmcalendar.execisesCompleted.value?.size!!>0){
                    startFragmentDoneTwo()
                }
            }

        }
    }
    fun startFragmentDoneTwo(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarTwo,DoneFragment())
            ?.commit()
    }
    fun startFragmentDoneThree(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarThree,DoneFragment())
            ?.commit()
    }
    fun startFragmentWithToDayOne(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarOne,TodayFragment())
            ?.commit()
    }
    fun startFragmentWithThisWeekOne(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarOne,OnWeekFragment())
            ?.commit()
    }
    fun startFragmentWithThisWeekTwo(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarTwo,OnWeekFragment())
            ?.commit()
    }

    fun startFragmentCompleteOne(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarOne,CompleteFragment())
            ?.commit()
    }
    fun startFragmentWithNextWeekTwo(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.framecalendarTwo,NextWeekFragment())
            ?.commit()
    }
}