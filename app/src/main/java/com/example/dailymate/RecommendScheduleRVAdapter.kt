package com.example.dailymate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Schedule(val title: String, val content: String)

class RecommendScheduleRVAdapter(private var schedules: List<Schedule>) :
    RecyclerView.Adapter<RecommendScheduleRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = schedules[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return schedules.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val scheduleTitle: TextView = itemView.findViewById(R.id.item_title_tv)
        private val scheduleContent: TextView = itemView.findViewById(R.id.item_content_tv)

        fun bind(item: Schedule) {
            scheduleTitle.text = item.title
            scheduleContent.text = item.content
        }
    }
}
