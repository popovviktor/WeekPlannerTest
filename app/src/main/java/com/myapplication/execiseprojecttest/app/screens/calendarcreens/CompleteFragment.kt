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
import com.myapplication.execiseprojecttest.databinding.FragmentCompleteBinding

class CompleteFragment : Fragment() {
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    lateinit var binding:FragmentCompleteBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCompleteadapterrv()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompleteBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CompleteFragment()
    }
    fun initCompleteadapterrv(){
        val adapter = AdapterOtherGroup()
        adapter.clear()
        adapter.addAll(vmcalendar.execisesCompleted.value!!)
        var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
        binding.rvCompleteCalendar.layoutManager = grid
        binding.rvCompleteCalendar.adapter= adapter
    }
}