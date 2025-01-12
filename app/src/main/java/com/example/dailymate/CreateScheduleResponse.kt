package com.example.dailymate

import java.time.LocalDateTime

data class CreateScheduleResponse(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: ScheduleResult
)

data class ScheduleResult(
    val scheduleId: Int,
    val createdAt: LocalDateTime
)

