package com.example.weatherapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val API_KEY = "YOUR_ACCUWEATHER_API_KEY"
    private val LOCATION_KEY = "328328" // Example: London

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherText = findViewById<TextView>(R.id.weatherText)

        RetrofitClient.instance.getCurrentWeather(LOCATION_KEY, API_KEY)
            .enqueue(object : Callback<List<WeatherResponse>> {
                override fun onResponse(call: Call<List<WeatherResponse>>, response: Response<List<WeatherResponse>>) {
                    if (response.isSuccessful) {
                        val weather = response.body()?.firstOrNull()
                        weatherText.text = "${weather?.WeatherText} - ${weather?.Temperature?.Metric?.Value}°${weather?.Temperature?.Metric?.Unit}"
                    }
                }

                override fun onFailure(call: Call<List<WeatherResponse>>, t: Throwable) {
                    weatherText.text = "Error: ${t.message}"
                }
            })
    }
}
