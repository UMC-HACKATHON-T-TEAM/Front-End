package com.example.dailymate

data class WeatherResponse(
    val weatherData: WeatherData,
    val airQualityData: AirQualityData
)

data class WeatherData(
    val main: Main
)

data class Main(
    val temp: Double,
    val feels_like: Double
)

data class AirQualityData(
    val list: List<AirQualityItem>
)

data class AirQualityItem(
    val components: Components
)

data class Components(
    val pm10: String
)

