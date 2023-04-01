package com.myapplication.execiseprojecttest.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.execiseprojecttest.R
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelForRvDates
import com.myapplication.execiseprojecttest.app.viewmodels.ViewModelHomeExecise
import com.myapplication.execiseprojecttest.databinding.ItemRvDateBinding

class AdapterDates(private val vmhome: ViewModelHomeExecise, private val vmdates: ViewModelForRvDates):RecyclerView.Adapter<AdapterDates.DatesHoplder> (){
    private val colorsBackList = ArrayList<String>()
    private val digitsList = ArrayList<Int>()
    private val dayOfWeek = ArrayList<String>()
    private val selectors = ArrayList<Boolean>()

    class DatesHoplder(item: View):RecyclerView.ViewHolder(item) {
    private val binding = ItemRvDateBinding.bind(item)
        fun bind(itemBack:String, digit:Int, dayOfWeek:String,
                 vmhome: ViewModelHomeExecise,
                 vmdates: ViewModelForRvDates,
                 isSelected:Boolean){
             binding.textDayOfWeek.text = dayOfWeek
             binding.digitDay.text = digit.toString()
                if (isSelected==false){binding.backcolor.setBackgroundColor(Color.parseColor(itemBack))}
                if (isSelected==true){binding.backcolor.setBackgroundColor(Color.parseColor("#72D861"))}

                binding.backcolor.setOnClickListener {
                    vmdates.initwithoutThisDaySelected()
                    vmhome.setintDay(digit)
                    vmhome.findExecies(vmhome.allExecises.value!!)
                    var index = vmdates.findIndexDigitInAllDigit(digit)
                    vmdates.selecteditems.value?.set(index,true)
                    System.out.println(index.toString() + "vmhome.initday()")


        }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatesHoplder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_date,parent,false)
        return DatesHoplder(view)
    }

    override fun onBindViewHolder(holder: DatesHoplder, position: Int) {
        holder.bind(colorsBackList.get(position),
            digitsList.get(position),
            dayOfWeek.get(position),vmhome,vmdates,
            selectors.get(position))
    }

    override fun getItemCount(): Int {
        return digitsList.size
    }
    fun addAll(arrcolor:ArrayList<String>,arrdigit:ArrayList<Int>,arrdayOfWeek:ArrayList<String>,arrSelected:ArrayList<Boolean>){
        colorsBackList.addAll(arrcolor)
        digitsList.addAll(arrdigit)
        dayOfWeek.addAll(arrdayOfWeek)
        selectors.addAll(arrSelected)
        notifyDataSetChanged()
    }
    fun clear(){
        colorsBackList.clear()
        digitsList.clear()
        dayOfWeek.clear()
        selectors.clear()
        notifyDataSetChanged()
    }

}