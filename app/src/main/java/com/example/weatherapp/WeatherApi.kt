package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("currentconditions/v1/{locationKey}")
    fun getCurrentWeather(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey: String
    ): Call<List<WeatherResponse>>

    @GET("forecasts/v1/daily/5day/{locationKey}")
    fun getForecast(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey: String,
        @Query("metric") metric: Boolean = true
    ): Call<ForecastResponse>
}

