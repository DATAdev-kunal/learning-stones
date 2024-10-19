package me.giantnova.weatherapp.ui.weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.giantnova.weatherapp.data.model.WeatherData
import me.giantnova.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = mutableStateOf<WeatherState>(WeatherState.Loading)
    val state: State<WeatherState> = _state

    fun getWeatherData(cityName: String) {
        viewModelScope.launch {
            try {
                val weatherData = repository.getWeatherData(cityName)
                _state.value = WeatherState.Success(weatherData)
            } catch (e: Exception) {
                _state.value = WeatherState.Error("An error occurred: ${e.message}")
            }
        }
    }
}

sealed class WeatherState {
    data object Loading : WeatherState()
    data class Success(val data: WeatherData) : WeatherState()
    data class Error(val message: String) : WeatherState()
}