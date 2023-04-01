package com.myapplication.execiseprojecttest.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelCalendar
import com.myapplication.execiseprojecttest.databinding.ItemRvExeciseHomeBinding

class AdapterExeciseHome(private val vmcalendar: ViewModelCalendar):RecyclerView.Adapter<AdapterExeciseHome.ExeciseHomeHolder>() {
    private val execisesName =ArrayList<String>()
    private val execisesSelectors =ArrayList<Boolean>()
    class ExeciseHomeHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding = ItemRvExeciseHomeBinding.bind(item)
        fun bind(execiseName:String,execiseSelector:Boolean,vmcalendar: ViewModelCalendar){
            if (vmcalendar.funvisibleButton(execiseName)){
                binding.btnComplete.visibility =View.INVISIBLE
            }
            var str =execiseName +" completed"
            binding.btnComplete.text = str
            binding.btnComplete.setOnClickListener {
            vmcalendar.setThisExeciseComplete(execiseName)
            binding.btnComplete.visibility = View.INVISIBLE
            vmcalendar.fundataForTodayAdapter()
            vmcalendar.fundataForCompleted()
            vmcalendar.fundataForThisWeekAdapter()
            vmcalendar.fundataForNextWeekAdapter()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExeciseHomeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_execise_home,parent,false)
        return ExeciseHomeHolder(view)
    }

    override fun onBindViewHolder(holder: ExeciseHomeHolder, position: Int) {
        holder.bind(execisesName.get(position),execisesSelectors.get(position),vmcalendar)
    }

    override fun getItemCount(): Int {
        return execisesName.size
    }
    fun addAll(arrExecises:ArrayList<String>,arrSelectors:ArrayList<Boolean>){
        execisesName.addAll(arrExecises)
        execisesSelectors.addAll(arrSelectors)
        notifyDataSetChanged()
    }
    fun clear(){
        execisesName.clear()
        execisesSelectors.clear()
        notifyDataSetChanged()
    }
}