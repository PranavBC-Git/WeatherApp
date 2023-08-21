package com.example.weatherapp.data

import com.example.weatherapp.data.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("forecast.json")
    suspend fun getForecastData(
        @Query("key") key: String = "8b6fbf82b5a7446082954556230508",
        @Query("q") city: String = "Bangalore",
        @Query("days") day: String = "7"
    ): WeatherData
}