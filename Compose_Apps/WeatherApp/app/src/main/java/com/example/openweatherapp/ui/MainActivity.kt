package com.example.openweatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.openweatherapp.ui.theme.WeatherAppTheme
import com.example.openweatherapp.ui.weather.WeatherHomeContent
import com.example.openweatherapp.ui.weather.WeatherHomeScreen
import com.example.openweatherapp.ui.weather.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
//                    WeatherHomeContent()
                    WeatherHomeScreen()
                }
            }
        }
    }
}