package com.myapplication.execiseprojecttest.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.screens.CalendarFragment
import com.myapplication.execiseprojecttest.app.screens.mainscreen.DatesFragment
import com.myapplication.execiseprojecttest.app.screens.homescreen.ExecisesThisDayFragment
import com.myapplication.execiseprojecttest.app.viewmodels.MainViewModel
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelCalendar
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelForRvDates
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelHomeExecise
import com.myapplication.execiseprojecttest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()
    private val vmdates: ViewModelForRvDates by viewModels()
    private val vmhome: ViewModelHomeExecise by viewModels()
    private val vmcalendar: ViewModelCalendar by viewModels()
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navController = findNavController(R.id.nav_host)
        val bottomnav = binding.bottomnavmenu
        //bottomnav.setupWithNavController(navController)
        bottomnav.setOnItemSelectedListener {
            if (it.itemId == R.id.nav_other1)
            if (it.itemId == R.id.nav_home)
                vmhome.setAllExecises(vm.execises.value?.data!!.execises)
                vmhome.findExecies(vm.execises.value?.data!!.execises)
                rewriteDateAndExecises()
            if (it.itemId == R.id.nav_other2) rewriteDates()
            if (it.itemId == R.id.nav_calendar)
                initCalendarPAge()
                initDefaultDatesBar()
            return@setOnItemSelectedListener true}
        vm.execises.observe(this, androidx.lifecycle.Observer {
            initVMCalendar()
            if (bottomnav.selectedItemId==R.id.nav_home){
                if (it!=null){
                    rewriteDates()
                    vmcalendar.setExecisesAll(vm.execises.value!!.data!!.execises)
            }}
        })
        vmhome.execisesLive.observe(this, Observer {
            if (bottomnav.selectedItemId==R.id.nav_home){
                rewriteDateAndExecises()
            }
        })
    }

    fun initDefaultDatesBar(){
        vmdates.initSelected()
        rewriteDates()
    }
    fun initCalendarPAge(){
        binding.framedates.isClickable = false
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framehome, CalendarFragment())
            .commit()
    }

    fun rewriteDateAndExecises(){
        vmhome.initday()
        rewriteDates()
        rewriteHomeExecises()
    }
    fun rewriteDates(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framedates, DatesFragment())
            .commit()
    }
    fun rewriteHomeExecises(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framehome, ExecisesThisDayFragment())
            .commit()
    }
    fun initVMCalendar(){
        vmcalendar.setExecisesAll(vm.execises.value!!.data!!.execises)
        vmcalendar.setSelectors()
        vmcalendar.setAllNamesExis()
        vmcalendar.setDigitsAllDAy(vmdates.digitsAllday.value!!)
        vmcalendar.setDigitsThisWeek()
        vmcalendar.setDigitsNextWeek()
        initDataForAdaptersCalendar()
    }
    fun initDataForAdaptersCalendar(){
        vmcalendar.fundataForTodayAdapter()
        vmcalendar.fundataForCompleted()
        vmcalendar.fundataForThisWeekAdapter()
        vmcalendar.fundataForNextWeekAdapter()
    }

}





