package com.example.weatherapp


data class WeatherResponse(
    val WeatherText: String,
    val Temperature: Temperature
)

data class Temperature(
    val Metric: Metric
)

data class Metric(
    val Value: Double,
    val Unit: String
)