package com.example.weatherapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.data.WeatherData.*
import com.example.weatherapp.databinding.LayoutForecastWeekItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlin.math.roundToInt

class WeeklyForecastAdapter : RecyclerView.Adapter<WeeklyForecastAdapter.ViewHolder>() {

    private val mForecastList = mutableListOf<Forecast.Forecastday?>()

    fun updateForecastData(data: List<Forecast.Forecastday?>) {
        mForecastList.clear()
        mForecastList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutForecastWeekItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Forecast.Forecastday?) {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val date: Date? = sdf.parse(item?.date.toString())
            sdf.applyPattern("EEEE")
            val str = date?.let { sdf.format(it) }
            binding.tvLine1.text = str
            val url = item?.hour?.get(17)?.condition?.icon.toString()
            Glide.with(binding.root).load("https:" + url)
                .override(200, 200)
                .centerCrop()
                .into(binding.ivCondition)
            binding.tvLine3.text = item?.day?.maxtempC?.roundToInt().toString()+"°C"
            binding.tvLine4.text= item?.day?.mintempC?.roundToInt().toString()+"°C"
            binding.tvLine5.text = item?.day?.dailyChanceOfRain.toString()+"%"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutForecastWeekItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = mForecastList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mForecastList[position])
    }

}