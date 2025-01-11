package com.example.dailymate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdatper(private val ScheduleList: List<ScheduleItem>) : RecyclerView.Adapter<ScheduleAdatper.ScheduleViewHolder>() {

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.item_date_tv)
        val title: TextView = itemView.findViewById(R.id.item_title_tv)
        val content: TextView = itemView.findViewById(R.id.item_content_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.schedule_list, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val currentItem = ScheduleList[position]
        holder.date.text = currentItem.date
        holder.title.text = currentItem.date
        holder.content.text = currentItem.content
    }

    override fun getItemCount(): Int {
        return ScheduleList.size
    }
}