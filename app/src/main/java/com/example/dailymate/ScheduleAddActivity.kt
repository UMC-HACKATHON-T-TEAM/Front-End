package com.example.dailymate

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class ScheduleAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_add)

        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val scheduleEditText = findViewById<EditText>(R.id.scheduleEditText)
        val memoEditText = findViewById<EditText>(R.id.memoEditText)
        val dateText = dateEditText.text.toString()
        val scheduleText = scheduleEditText.text.toString()
        val memoText = memoEditText.text.toString()

        val apiService = RetrofitClient.apiService

        val addScheduleButton = findViewById<ImageButton>(R.id.add_schedule_button)

        addScheduleButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val schedule = CreateSchedule(dateText, scheduleText, memoText)
                    val response = apiService.createSchedule(userId = 1, schedule = schedule)
                    Log.d("ScheduleAddActivity", "API Response: $response")

                    if (response.isSuccessful) {
                        response.body()?.let {
                            // TODO: Handle the successful response
                        }
                        finish()
                    } else {
                        Log.e("ScheduleAddActivity", "API Error: ${response.code()}")
                    }
                } catch (e: Exception) {
                    Log.e("ScheduleAddActivity", "Exception: ${e.message}")
                }
            }

        }
    }
}