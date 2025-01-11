package com.example.dailymate

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class ScheduleAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_add)

        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val dateText = dateEditText.text.toString()
        val scheduleEditText = findViewById<EditText>(R.id.scheduleEditText)
        val scheduleText = scheduleEditText.text.toString()
        val memoEditText = findViewById<EditText>(R.id.memoEditText)
        val memoText = memoEditText.text.toString()

        val schedule = CreateSchedule(dateText, scheduleText, memoText)

        val apiService = RetrofitClient.apiService

        val addScheduleButton = findViewById<ImageButton>(R.id.add_schedule_button)
        addScheduleButton.setOnClickListener {
            // 버튼 클릭 시 실행할 코드
            lifecycleScope.launch {
                try {
                    val response = apiService.createSchedule(userId = 1, schedule = schedule)
                    if (response.isSuccessful) {
                        val createScheduleResponse = response.body()
                        if (createScheduleResponse != null) {
                            /* TODO */
                        }
                        // Finish the activity
                        finish()
                    } else {
                        Toast.makeText(this@ScheduleAddActivity, "Failed to create schedule", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@ScheduleAddActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}