package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.weatherapp.data.WeatherData.*
import com.example.weatherapp.databinding.LayoutForecastItemBinding
import kotlin.math.roundToInt

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private val mForecastList = mutableListOf<Forecast.Forecastday.Hour>()

    fun updateForecastData(data: List<Forecast.Forecastday.Hour>) {
        mForecastList.clear()
        mForecastList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutForecastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Forecast.Forecastday.Hour?) {
            binding.tvLine1.text = item?.time
            val url=item?.condition?.icon.toString()
            Glide.with(binding.root).load("https:"+url)
                .override(200, 200)
                .centerCrop()
                .into(binding.ivCondition)
            binding.tvLine3.text = item?.tempC?.roundToInt().toString()+"°"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutForecastItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = mForecastList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mForecastList[position])
    }

}