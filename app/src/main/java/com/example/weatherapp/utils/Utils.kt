package com.example.weatherapp.utils

import androidx.appcompat.app.AppCompatActivity

fun setWindowFlag(activity: AppCompatActivity, bits: Int, on: Boolean) {
    val win = activity.window
    val winParams = win.attributes
    if (on) {
        winParams.flags = winParams.flags or bits
    } else {
        winParams.flags = winParams.flags and bits.inv()
    }
    win.attributes = winParams
}