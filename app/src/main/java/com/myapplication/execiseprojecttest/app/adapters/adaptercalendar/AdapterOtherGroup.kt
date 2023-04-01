package com.myapplication.execiseprojecttest.app.adapters.adaptercalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.data.api.models.Execise
import com.myapplication.execiseprojecttest.databinding.ItemCalendarOtherNotTodayBinding
import com.myapplication.execiseprojecttest.databinding.ItemCalendarTodayBinding

class AdapterOtherGroup:RecyclerView.Adapter<AdapterOtherGroup.OtherGoupHolder>() {
    private val execises = ArrayList<Execise>()
    class OtherGoupHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding = ItemCalendarOtherNotTodayBinding.bind(item)
            fun bind(execise: Execise){
            binding.textInfoDateOther.text = execise.dayofweek + ", "+execise.month+" "+execise.date
            binding.textNameExeciseOther.text = execise.name
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherGoupHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_other_not_today,parent,false)
        return OtherGoupHolder(view)
    }

    override fun onBindViewHolder(holder: OtherGoupHolder, position: Int) {
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