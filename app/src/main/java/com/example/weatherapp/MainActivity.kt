package com.example.weatherapp

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.ui.HomeFragment
import com.example.weatherapp.ui.SettingsFragment
import com.example.weatherapp.ui.ThirdFragment
import com.example.weatherapp.utils.setWindowFlag


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

        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT

        val firstFragment = HomeFragment()
        val  thirdFragment= SettingsFragment()
        val secondFragment = ThirdFragment()

        val listOfFragment = listOf(firstFragment, secondFragment, thirdFragment)

        setCurrentFragment(firstFragment)

        binding.bottomBar.onItemSelected = {
            setCurrentFragment(listOfFragment[it])
        }
    }

    override fun onResume() {
        super.onResume()
      val city= getSharedPreferences("weatherapp",0)
            .getString("city_name","Bangalore")
        viewModel.getWeatherData(city!!)
    }

}