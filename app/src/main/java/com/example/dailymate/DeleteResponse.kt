package com.example.dailymate

data class DeleteResponse(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: Any?
)

