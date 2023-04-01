package com.myapplication.execiseprojecttest.app.screens.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapplication.execiseprojecttest.databinding.FragmentHeaderBinding


class HeaderMainFragment : Fragment() {
    lateinit var binding: FragmentHeaderBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeaderBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
      @JvmStatic
        fun newInstance() = HeaderMainFragment()
    }
}