package com.example.dailymate

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class ScheduleFragment : Fragment(R.layout.schedule_manage) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScheduleAdatper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.schedule_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val apiService = RetrofitClient.apiService

        lifecycleScope.launch {
            try {
                val response = apiService.getSchedule(userId = 1)
                if (response.isSuccessful) {
                    val scheduleList = response.body() as? List<ScheduleItem> ?: emptyList()
                    adapter = ScheduleAdatper(scheduleList)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(requireContext(), "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        val notificationButton = view.findViewById<FloatingActionButton>(R.id.item_trash_iv)
        notificationButton.setOnClickListener {

            val deleteIntent = Intent(context, NotificationReceiver::class.java).apply {
                action = "DELETE_ACTION"
            }
            val cancelIntent = Intent(context, NotificationReceiver::class.java).apply {
                action = "CANCEL_ACTION"
            }

            val deletePendingIntent: PendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                deleteIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            val cancelPendingIntent: PendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                cancelIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val notification = NotificationCompat.Builder(requireContext(), "your_channel_id")
                .setContentTitle("이 일정을 삭제할까요?")
                .setContentText("삭제 시 복구되지 않으니 신중하게 선택해주세요.")
                .addAction(R.drawable.btn_delete, "Delete", deletePendingIntent)
                .addAction(R.drawable.btn_cancel, "Cancel", cancelPendingIntent)
                .setAutoCancel(true)
                .build()

            val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(1, notification)
        }

        val addScheduleButton = view.findViewById<FloatingActionButton>(R.id.to_add_schedule_activity_button)
        addScheduleButton.setOnClickListener {
            val intent = Intent(requireContext(), ScheduleAddActivity::class.java)
            startActivity(intent)
        }
    }
}