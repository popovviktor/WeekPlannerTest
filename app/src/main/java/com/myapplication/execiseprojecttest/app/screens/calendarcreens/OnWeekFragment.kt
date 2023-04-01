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
import com.myapplication.execiseprojecttest.app.adapters.adaptercalendar.AdapterOtherGroup
import com.myapplication.execiseprojecttest.databinding.FragmentOnWeekBinding

class OnWeekFragment : Fragment() {
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    lateinit var binding:FragmentOnWeekBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initadapterrv()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnWeekBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = OnWeekFragment()
    }
    fun initadapterrv(){
        val adapter = AdapterOtherGroup()
        adapter.clear()
        adapter.addAll(vmcalendar.execisesThisWeek.value!!)
        var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
        binding.rvOnThisWeekCalendar.layoutManager = grid
        binding.rvOnThisWeekCalendar.adapter= adapter
    }
}