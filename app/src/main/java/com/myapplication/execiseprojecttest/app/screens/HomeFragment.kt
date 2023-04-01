package com.myapplication.execiseprojecttest.app.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.*
import com.myapplication.execiseprojecttest.app.screens.homescreen.ExecisesThisDayFragment
import com.myapplication.execiseprojecttest.app.viewmodels.MainViewModel
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelHomeExecise
import com.myapplication.execiseprojecttest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val vm: MainViewModel by activityViewModels()
    private val vmhome: ViewModelHomeExecise by activityViewModels()
    lateinit var binding:FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomePage()
        System.out.println("Инициалзц")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.out.println("HomeСоздана")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
         @JvmStatic
        fun newInstance() = HomeFragment()
            }
    fun initHomePage(){
        vmhome.initday()
        System.out.println("HomeСоздана в viewcreated")
        vm.execises.observe(requireActivity() as MainActivity, Observer {
            if (it!=null){
                vmhome.setAllExecises(vm.execises.value?.data!!.execises)
                vmhome.findExecies(vm.execises.value?.data!!.execises)
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.framehome, ExecisesThisDayFragment())
                    ?.commit()
                System.out.println("Сработало в ome")
            }})
    }
}
