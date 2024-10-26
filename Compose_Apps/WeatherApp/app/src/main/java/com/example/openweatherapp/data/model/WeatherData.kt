package com.example.openweatherapp.data.model

data class WeatherResponse(
    val name: String?,               // City Name, nullable to handle missing data
    val main: Main?,                 // Main weather info, nullable
    val weather: List<Weather>?,     // Weather descriptions, nullable
    val visibility: Int?,            // Visibility in meters, nullable
    val wind: Wind?,                 // Wind info, nullable
    val sys: Sys?                // System info (sunrise, sunset), nullable
)

data class Main(
    val temp: Float?,                // Current temperature, nullable
    val humidity: Int?,              // Humidity, nullable
    val feels_like: Float?,          // Feels like temperature, nullable
    val pressure: Int?,              // Pressure, nullable
    val sea_level: Int?              // Sea level pressure, nullable
)

data class Weather(
    val description: String?         // Weather description, nullable
)

data class Wind(
    val speed: Float?,               // Wind speed, nullable
    val deg: Int?                    // Wind direction in degrees, nullable
)

data class Sys(
    val sunrise: Long?,              // Sunrise time, nullable
    val sunset: Long?                // Sunset time, nullable
)
