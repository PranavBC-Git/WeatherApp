package com.example.weatherapp.ui

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.example.weatherapp.MainActivity
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
            val cityName = binding.etCity.text
            if (cityName.isNullOrEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    "Please Enter a City!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            requireActivity()
                .getSharedPreferences("weatherapp", 0).edit()
                .putString("city_name", cityName.toString())
                .apply()
            val i= Intent(activity,MainActivity::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0,0)
        }
    }

}