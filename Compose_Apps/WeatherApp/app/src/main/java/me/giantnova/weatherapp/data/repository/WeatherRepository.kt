package me.giantnova.weatherapp.data.repository

import me.giantnova.weatherapp.data.api.WeatherApi
import me.giantnova.weatherapp.data.model.WeatherData
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getWeatherData(cityName: String): WeatherData {
        return api.getWeatherData(cityName)
    }
}