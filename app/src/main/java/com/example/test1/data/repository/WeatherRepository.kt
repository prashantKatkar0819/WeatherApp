package com.example.test1.data.repository

import com.example.test1.data.network.WeatherApiService
import com.example.test1.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class WeatherRepository(private val apiService: WeatherApiService) {
    suspend fun fetchWeather(city: String): Resource {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getWeather(city, "c214ad83cc85ec2f3acafcbf44308227")
                Resource.Success(response)
            } catch (e: HttpException) {
                Resource.Error("City not found.")
            } catch (e: IOException) {
                Resource.Error("Network error. Please try again.")
            }
        }
    }
}