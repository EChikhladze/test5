package com.example.test5.common

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json

data class NewCourse(
    @Json(name = "id") val id: Int,
    @Json(name = "icon_type") val iconType: IconType?,
    @Json(name = "duration") val duration: String,
    @Json(name = "title") val title: String,
    @Json(name = "question") val question: String,
    @Json(name = "main_color") val mainColor: String,
)

enum class IconType(val type: String) {
    SETTINGS("settings"),
    CARD("card");

    companion object {
        fun fromString(type: String): IconType? {
            return entries.find { it.type == type }
        }
    }
}

class IconTypeAdapter {
    @FromJson
    fun fromJson(type: String): IconType? {
        return IconType.fromString(type)
    }
}