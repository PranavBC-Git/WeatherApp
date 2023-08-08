package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.ApiInterface
import com.example.weatherapp.data.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainViewModel: ViewModel() {
    private lateinit var apiService: ApiInterface

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData>
        get() = _weatherData

    init {
        createApiService()
    }


    private fun createApiService() {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       val client =  OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(ApiInterface::class.java)
    }


    fun getWeatherData(city:String): String{

        //return "Pranav 123"
        try {
            viewModelScope.launch(Dispatchers.IO){
                _weatherData.postValue(apiService.getForecastData(city=city))
                Log.d("msg1",apiService.getForecastData().toString())
            }
        }catch (e: Exception){
            Log.d("msg1",e.toString())
        }
        return "Pranav 123"

    }
}