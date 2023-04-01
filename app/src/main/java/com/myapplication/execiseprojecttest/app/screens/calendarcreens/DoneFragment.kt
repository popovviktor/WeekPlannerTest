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
import com.myapplication.execiseprojecttest.databinding.FragmentDoneBinding


class DoneFragment : Fragment() {
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    lateinit var binding:FragmentDoneBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapterDonerv()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoneBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DoneFragment()
    }
    fun initAdapterDonerv(){
        val adapter = AdapterOtherGroup()
        adapter.clear()
        adapter.addAll(vmcalendar.execisesCompleted.value!!)
        var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
        binding.rvDoneCalendar.layoutManager = grid
        binding.rvDoneCalendar.adapter= adapter
    }
}