package com.example.weatherapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentForecastBinding
import com.example.weatherapp.databinding.FragmentSettingsBinding
import com.example.weatherapp.viewmodel.ThirdViewModel

class ForecastFragment : Fragment() {

    companion object {
        fun newInstance() = ForecastFragment()
    }

    private val weeklyForecastAdapter by lazy {
        WeeklyForecastAdapter()
    }

    private lateinit var viewModel: ThirdViewModel
    private val mainViewModel by activityViewModels<MainViewModel>()

    private lateinit var binding: FragmentForecastBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.weatherData.observe(viewLifecycleOwner) {
            binding.rvForecastWeekly.apply {
                adapter = weeklyForecastAdapter
                it.forecast?.forecastday?.let {
                    weeklyForecastAdapter.updateForecastData(it)
                }
            }
        }
    }
}