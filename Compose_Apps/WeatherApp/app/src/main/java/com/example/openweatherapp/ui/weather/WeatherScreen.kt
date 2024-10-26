package com.example.openweatherapp.ui.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.openweatherapp.R
import com.example.openweatherapp.ui.theme.BlueJC
import com.example.openweatherapp.ui.theme.DarkBlueJC
import com.example.openweatherapp.ui.theme.WeatherAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WeatherScreen() {
    val viewModel: WeatherViewModel = viewModel()
    val weatherData by viewModel.weatherData.collectAsState()

    var city by remember {
        mutableStateOf("")
    }

    val apiKey = "07018b5d030a7bd5108d9c17eb710792"

    Box(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.weather_bkg),
            contentScale = ContentScale.FillBounds
        )){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                placeholder = { Text(text = "Enter City", color = Color.Gray) },
                maxLines = 1,
                leadingIcon = {Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    tint = DarkBlueJC
                )},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = BlueJC,
                    focusedIndicatorColor = BlueJC,
                    focusedLabelColor = DarkBlueJC
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.fetchWeather(city, apiKey) },
                colors = ButtonDefaults.buttonColors(DarkBlueJC),
                shape = RoundedCornerShape(30.dp)
            )
                {
                Text(text = "Get Weather")
            }
            Spacer(modifier = Modifier.height(16.dp))

            //Weather Details Section
            //FETCHED DATA HERE
            weatherData?.let {

                // CITY & TEMP
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(
                        label = "City",
                        value = it.name?: "N/A",
                        icon = Icons.Default.LocationOn
                    )
                    WeatherCard(
                            label = "Temperature",
                            value = getTempInCelcius(it.main?.temp ?: 0f),
                            icon = Icons.Default.Warning
                        )
                }

                // FEEL & HUMIDITY
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(
                            label = "Feels Like",
                            value = getTempInCelcius(it.main?.feels_like ?: 0f),
                            icon = Icons.Default.Star
                        )
                    WeatherCard(
                        label = "Humidity",
                        value = "${it.main?.humidity ?: "N/A"}%",
                        icon = Icons.Default.Warning
                    )
                }

                // WIND SPEED & DIRECTION
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(
                        label = "Wind Speed",
                        value = "${it.wind?.speed ?: "N/A"} m/s",
                        icon = Icons.Default.Edit
                    )
                    WeatherCard(
                        label = "Wind Direction",
                        value = getWindDirection(it.wind?.deg),
                        icon = Icons.Default.Info // Use a compass icon for wind direction
                    )
                }

                // VISIBILITY & PRESSURE
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(
                        label = "Visibility",
                        value = "${it.visibility?.div(1000) ?: "N/A"} km",
                        icon = Icons.Default.Check
                    )
                    WeatherCard(
                        label = "Pressure",
                        value = "${it.main?.pressure?: "N/A"} hPa",
                        icon = Icons.Default.Check
                    )
                }

                // SUNRISE and SUNSET
                val sunriseTime = it.sys?.sunrise?.let { it1 -> formatUnixTime(it1) }
                val sunsetTime = it.sys?.sunset?.let { it1 -> formatUnixTime(it1) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherCard(
                        label = "Sunrise",
                        value = sunriseTime ?: "N/A",
                        icon = Icons.Default.KeyboardArrowUp
                    )
                    WeatherCard(
                        label = "Sunset",
                        value = sunsetTime ?: "N/A",
                        icon = Icons.Default.KeyboardArrowDown
                    )
                }
            }
        }
    }
}

fun formatUnixTime(time: Long): String {
    val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
    val date = Date(time * 1000) // Convert Unix time (in seconds) to milliseconds
    return sdf.format(date)
}

fun getTempInCelcius(temp: Float): String {
    val celcius = String.format("%.2f", temp - 273.15)
    return "$celcius °C"
}
fun getWindDirection(degrees: Int?): String {
    if (degrees == null) return "Unknown"
    return when (degrees) {
        in 0..44 -> "North"
        in 45..89 -> "North-East"
        in 90..134 -> "East"
        in 135..179 -> "South-East"
        in 180..224 -> "South"
        in 225..269 -> "South-West"
        in 270..314 -> "West"
        in 315..359 -> "North-West"
        else -> "Unknown"
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    WeatherAppTheme {
        WeatherScreen()
    }
}