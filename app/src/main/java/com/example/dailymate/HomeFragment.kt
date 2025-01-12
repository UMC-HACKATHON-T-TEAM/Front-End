package com.example.dailymate

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.dailymate.databinding.FragmentHomeBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {
    private var tvTemperature: TextView? = null
    private var tvFeelsLike: TextView? = null
    private var tvPm10: TextView? = null
    private var tvRainProbability: TextView? = null
    private lateinit var binding: FragmentHomeBinding

    private val dummyWeatherResponse = WeatherResponse(
        WeatherData(Main(16.0, 14.0)),
        AirQualityData(listOf(AirQualityItem(Components("좋음"))))
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        tvTemperature = view.findViewById(R.id.home_feeltemperature_tv)
        tvFeelsLike = view.findViewById(R.id.home_realtemperature_tv)
        tvPm10 = view.findViewById(R.id.home_finedustnum_tv)
        tvRainProbability = view.findViewById(R.id.home_waterpercent_tv)

        // Retrofit 설정
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 버튼 클릭 리스너 추가
        binding.homeGoBtn.setOnClickListener {
            // RecommendFragment로 화면 전환
            parentFragmentManager.commit {
                replace(R.id.main_container, RecommendFragment())
                addToBackStack(null)
            }
        }


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