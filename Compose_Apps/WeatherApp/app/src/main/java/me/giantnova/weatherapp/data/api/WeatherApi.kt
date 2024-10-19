package me.giantnova.weatherapp.data.api

import me.giantnova.weatherapp.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = "YOUR_API_KEY_HERE"
    ): WeatherData
}