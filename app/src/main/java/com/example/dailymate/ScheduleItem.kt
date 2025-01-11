package com.example.dailymate

data class ScheduleItem(
    val scheduleId: Int,
    val date: String,
    val title: String,
    val content: String,
    val createdAt: String
)