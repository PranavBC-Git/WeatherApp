package com.example.weatherapp.data

import com.example.weatherapp.data.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("forecast.json")
    suspend fun getForecastData(
        @Query("key") key: String = "1424a36fdb304cb79a3151954232108",
        @Query("q") city: String = "Bangalore",
        @Query("days") day: Int = 8
    ): WeatherData
}