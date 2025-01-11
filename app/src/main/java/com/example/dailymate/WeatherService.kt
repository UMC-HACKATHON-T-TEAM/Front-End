package com.example.dailymate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
    @GET("api/weather")
    fun getWeather(@Query("city") city: String?): Call<WeatherResponse?>?
}
