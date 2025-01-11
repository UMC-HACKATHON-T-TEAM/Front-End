package com.example.dailymate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.String

class FragmentHome : Fragment() {
    private var tvTemperature: TextView? = null
    private var tvFeelsLike: TextView? = null
    private var tvPm10: TextView? = null
    private var tvRainProbability: TextView? = null


    private val dummyWeatherResponse = WeatherResponse(
        WeatherData(Main(16.0, 14.0)),
        AirQualityData(listOf(AirQualityItem(Components("좋음"))))
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        tvTemperature = view.findViewById(R.id.home_feeltemperature_tv)
        tvFeelsLike = view.findViewById(R.id.home_realtemperature_tv)
        tvPm10 = view.findViewById(R.id.home_finedustnum_tv)
        tvRainProbability = view.findViewById(R.id.home_waterpercent_tv)

        // Retrofit 설정
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // WeatherService 인터페이스
        val service = retrofit.create(WeatherService::class.java)


        updateUIWithDummyData()

        return view
    }

    // 더미 데이터로 UI를 업데이트하는 함수
    private fun updateUIWithDummyData() {
        // 더미 데이터 사용
        tvTemperature?.text = String.format("%.2f°C", dummyWeatherResponse.weatherData.main.temp)
        tvFeelsLike?.text = String.format(" %.2f°C", dummyWeatherResponse.weatherData.main.feels_like)
        tvPm10?.text = String.format("좋음³", dummyWeatherResponse.airQualityData.list[0].components.pm10)
        tvRainProbability?.text = " 0%"
    }

    companion object {
        private const val BASE_URL = "http://your_spring_boot_server_url" // Spring Boot 서버 URL
    }
}