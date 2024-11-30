package com.example.test1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test1.data.repository.WeatherRepository
import com.example.test1.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherState = MutableStateFlow<Resource>(Resource.Loading)
    val weatherState: StateFlow<Resource> = _weatherState

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            _weatherState.value = Resource.Loading
            _weatherState.value = repository.fetchWeather(city)
        }
    }
}