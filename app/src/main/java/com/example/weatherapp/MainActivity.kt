package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.ui.HomeFragment
import com.example.weatherapp.ui.SettingsFragment
import com.example.weatherapp.ui.ForecastFragment


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(binding.containerMain.id, fragment)
            commit()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val firstFragment = HomeFragment()
        val thirdFragment = SettingsFragment()
        val secondFragment = ForecastFragment()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val listOfFragment = listOf(firstFragment, secondFragment, thirdFragment)


        setCurrentFragment(firstFragment)

        binding.bottomBar.onItemSelected = {
            setCurrentFragment(listOfFragment[it])
        }


    }

}