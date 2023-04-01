package com.myapplication.execiseprojecttest.app.adapters.adaptercalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.adapters.AdapterDates
import com.myapplication.execiseprojecttest.data.api.models.Execise
import com.myapplication.execiseprojecttest.databinding.ItemCalendarTodayBinding
import com.myapplication.execiseprojecttest.databinding.ItemRvDateBinding

class AdapterToday:RecyclerView.Adapter<AdapterToday.TodayHolder>() {
    private val execises = ArrayList<Execise>()
    class TodayHolder(item:View):RecyclerView.ViewHolder(item) {
        private val binding = ItemCalendarTodayBinding.bind(item)
            fun bind(execise: Execise){
            binding.textInfoDateOther.text = execise.dayofweek+", "+execise.month+" "+execise.date
            binding.textNameExeciseOther.text = execise.name
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_today,parent,false)
        return TodayHolder(view)
    }

    override fun onBindViewHolder(holder: TodayHolder, position: Int) {
        holder.bind(execises.get(position))
    }

    override fun getItemCount(): Int {
        return execises.size
    }
    fun addAll(arr:ArrayList<Execise>){
        execises.addAll(arr)
    }
    fun clear(){
        execises.clear()
    }
}