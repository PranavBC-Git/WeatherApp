package com.example.weatherapp.ui

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.utils.setWindowFlag
import com.example.weatherapp.viewmodel.HomeViewModel
import kotlin.math.roundToInt

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentHomeBinding

    private val forecastAdapter by lazy {
        ForecastAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val city= requireActivity().getSharedPreferences("weatherapp",0)
            .getString("city_name","Bangalore")
        Log.d("TAG", city.toString())
        mainViewModel.getWeatherData(city!!, days=7)
        mainViewModel.weatherData.observe(viewLifecycleOwner){
            binding.tvTemperature.text = getString(R.string.temperature_in_celcius, it.current?.tempC?.roundToInt().toString())
            binding.tvWind.text = getString(R.string.wind,it.current?.windKph.toString())
            binding.tvPressure.text = getString(R.string.pressure,it.current?.pressureMb.toString())
            binding.tvHumidity.text = getString(R.string.humidity,it.current?.humidity.toString())
            binding.rvForecast.apply {
                adapter = forecastAdapter
                it.forecast?.forecastday?.get(0)?.hour?.let {
                    forecastAdapter.updateForecastData(it)
                }

            }
        }
    }



}