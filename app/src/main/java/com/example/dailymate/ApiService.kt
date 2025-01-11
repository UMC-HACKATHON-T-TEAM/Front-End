package com.example.dailymate

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/schedules/{scheduleId}")
    suspend fun getSchedule(
        @Query("userId") userId: Int
    ): Response<ScheduleResponse>

    @POST("/schedules/")
    suspend fun createSchedule(
        @Query("userId") userId: Int,
        @Body schedule: CreateSchedule
    ): Response<CreateScheduleResponse>

    @DELETE("/schedules/{scheduleId}")
    suspend fun deleteSchedule(
        @Path("scheduleId") scheduleId: Int
    ): Response<DeleteResponse>
}