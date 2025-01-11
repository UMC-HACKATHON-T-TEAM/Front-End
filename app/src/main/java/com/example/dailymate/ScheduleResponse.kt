package com.example.dailymate

data class ScheduleResponse(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: List<Schedule>
)

data class Schedule(
    val scheduleId: Int,
    val date: String,
    val title: String,
    val content: String,
    val createdAt: String
)
