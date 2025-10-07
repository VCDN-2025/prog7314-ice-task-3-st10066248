package com.example.weatherapp


data class ForecastResponse(
    val DailyForecasts: List<DailyForecast>
)

data class DailyForecast(
    val Date: String,
    val Temperature: ForecastTemp
)

data class ForecastTemp(
    val Minimum: Metric,
    val Maximum: Metric
)
