package com.example.weatherapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSettingsBinding
import com.example.weatherapp.viewmodel.SettingsViewModel

class SettingsFragment : Fragment() {

    private val viewModel by viewModels<SettingsViewModel>()
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.btCity.setOnClickListener {
            val cityName =binding.etCity.text
            if(cityName.isNullOrEmpty()){
                Toast.makeText(requireActivity(),"Please Enter a City!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                }

            requireActivity()
                .getSharedPreferences("weatherapp",0).edit()
                .putString("city_name", cityName.toString())
                .apply()
        }
    }

}