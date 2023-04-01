package com.myapplication.execiseprojecttest.app.screens.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelCalendar
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelHomeExecise
import com.myapplication.execiseprojecttest.app.adapters.AdapterExeciseHome
import com.myapplication.execiseprojecttest.app.screens.mainscreen.HeaderMainFragment
import com.myapplication.execiseprojecttest.databinding.FragmentExecisesThisDayBinding


class ExecisesThisDayFragment : Fragment() {
    lateinit var binding : FragmentExecisesThisDayBinding
    private val vmhome: ViewModelHomeExecise by activityViewModels()
    private val vmcalendar: ViewModelCalendar by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHomeHeader()
        initRecyclerHomeExecises()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExecisesThisDayBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExecisesThisDayFragment()
    }
    fun initHomeHeader(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.frameHeader, HeaderMainFragment())
            ?.commit()
    }
    fun initRecyclerHomeExecises(){
        val adapterhome = AdapterExeciseHome(vmcalendar)
        System.out.println("измение1")
        adapterhome.clear()
        adapterhome.addAll(vmhome.namesExecises(),vmcalendar.selectors.value!!)
        System.out.println(vmhome.namesExecises().size)
        var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
        binding.rvHomeExeciseThiSDAy.layoutManager = grid
        binding.rvHomeExeciseThiSDAy.adapter = adapterhome
        System.out.println("измение2")
    }
}