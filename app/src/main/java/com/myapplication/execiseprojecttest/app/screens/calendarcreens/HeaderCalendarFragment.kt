package com.myapplication.execiseprojecttest.app.screens.calendarcreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapplication.execiseprojecttest.R

class HeaderCalendarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header_calendar, container, false)
    }

    companion object {
       @JvmStatic
        fun newInstance() = HeaderCalendarFragment()
    }
}