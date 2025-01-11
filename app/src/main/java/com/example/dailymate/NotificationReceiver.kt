package com.example.dailymate

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            "DELETE_ACTION" -> context?.let {
                handleDeleteAction(
                    it,
                    scheduleId = 1
                )
            }
            "CANCEL_ACTION" -> handleCancelAction(context)
        }
    }

    fun handleDeleteAction(context: Context, scheduleId: Int) {

        val apiService = RetrofitClient.apiService

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.deleteSchedule(scheduleId)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        /* TODO */
                    } else {
                        /* TODO */
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun handleCancelAction(context: Context?) {
        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(1)
    }
}