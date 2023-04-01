package com.myapplication.execiseprojecttest.app.screens.calendarcreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelCalendar
import com.myapplication.execiseprojecttest.app.adapters.adaptercalendar.AdapterToday
import com.myapplication.execiseprojecttest.databinding.FragmentTodayBinding


class TodayFragment : Fragment() {
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    lateinit var binding:FragmentTodayBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initadapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
       @JvmStatic
        fun newInstance() = TodayFragment()
    }
    fun initadapter(){
        val adapter = AdapterToday()
        adapter.clear()
        adapter.addAll(vmcalendar.execisesToday.value!!)
        var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
        binding.rvTodayCalendar.layoutManager = grid
        binding.rvTodayCalendar.adapter= adapter
    }
}