package me.giantnova.weatherapp.ui.weather

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.giantnova.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    var cityName by remember { mutableStateOf("") }
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("Enter city name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.getWeatherData(cityName) }) {
            Text("Get Weather")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (state) {
            is WeatherState.Loading -> CircularProgressIndicator()
            is WeatherState.Success -> {
                Text("City: ${state.data.name}")
                Text("Temperature: ${state.data.main.temp}°C")
                Text("Humidity: ${state.data.main.humidity}%")
                Text("Description: ${state.data.weather.firstOrNull()?.description ?: "N/A"}")
            }
            is WeatherState.Error -> Text(state.message, color = MaterialTheme.colorScheme.error)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        WeatherScreen()
    }
}