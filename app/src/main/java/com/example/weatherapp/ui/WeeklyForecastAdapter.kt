package com.example.weatherapp.ui

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherData.Forecast
import com.example.weatherapp.databinding.LayoutForecastWeekItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
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
            sdf.applyPattern("EEEE\ndd/MM/YY")

            date?.let {

                binding.tvDate.applyDateStyle(sdf.format(it))
            }

            val url = item?.day?.condition?.icon.toString()
            Glide.with(binding.root).load("https:$url")
                .override(200, 200)
                .centerCrop()
                .into(binding.ivCondition)

            binding.tvMaxTemperature.text = item?.day?.maxtempC?.roundToInt().toString() + "°C"
            binding.tvMinTemperature.text = item?.day?.mintempC?.roundToInt().toString() + "°C"
            binding.tvRainchance.text = item?.day?.dailyChanceOfRain.toString() + "%"
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

    fun TextView.applyDateStyle(date: String) {
        val spannableString = SpannableString(date)
        spannableString.setSpan(RelativeSizeSpan(1.3f), 0, spannableString.indexOf('\n'), 0)
        val color = resources.getColor(R.color.lightGray, null)
        spannableString.setSpan(
            ForegroundColorSpan(color),
            0,
            spannableString.indexOf('\n'),
            0
        )
        text = spannableString
    }

}
