package com.example.openweatherapp.data.api

import com.example.openweatherapp.data.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = "07018b5d030a7bd5108d9c17eb710792"
    ): WeatherResponse

    companion object{
        fun create(): WeatherApi{
            val baseUrl = "https://api.openweathermap.org/data/2.5/"
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}