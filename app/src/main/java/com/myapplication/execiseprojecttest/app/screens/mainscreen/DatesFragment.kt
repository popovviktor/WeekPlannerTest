package com.myapplication.execiseprojecttest.app.screens.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.app.MainActivity
import com.myapplication.execiseprojecttest.app.viewmodels.MainViewModel
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelForRvDates
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelHomeExecise
import com.myapplication.execiseprojecttest.app.adapters.AdapterDates
import com.myapplication.execiseprojecttest.databinding.FragmentDatesBinding


class DatesFragment : Fragment() {
    private val vm: MainViewModel by activityViewModels()
    private val vmdates: ViewModelForRvDates by activityViewModels()
    private val vmhome: ViewModelHomeExecise by activityViewModels()
    lateinit var binding:FragmentDatesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initrecyclerviewDATES()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatesBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DatesFragment()
    }
    fun initrecyclerviewDATES(){
        val execises = vm.execises.value?.data?.execises
        val adapterdates = AdapterDates(vmhome,vmdates)
        vmdates.insertcolorsback(execises!!)
        adapterdates.addAll(vmdates.colorsback.value!!,vmdates.digitsAllday.value!!,vmdates.dayOfWeek.value!!,vmdates.selecteditems.value!!)
        var grid = GridLayoutManager(requireActivity() as MainActivity,1, RecyclerView.HORIZONTAL,false)
        binding.rvdate.layoutManager = grid
        binding.rvdate.adapter = adapterdates
    }
}