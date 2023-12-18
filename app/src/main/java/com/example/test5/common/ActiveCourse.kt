package com.example.test5.common

import com.squareup.moshi.Json

data class ActiveCourse(
    @Json(name = "id") val id: Int,
    @Json(name = "booking_time") val bookingTime: String,
    @Json(name = "progress") val progress: Int,
    @Json(name = "title") val title: String,
    @Json(name = "main_color") val mainColor: String,
    @Json(name = "background_color_present") val backgroundColorPresent: Int,
    @Json(name = "play_button_color_present") val playButtonColorPresent: Int,
    @Json(name = "image") val image: String
)
