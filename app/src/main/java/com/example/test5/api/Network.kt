package com.example.test5.api

import com.example.test5.common.IconTypeAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {
    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val moshi = Moshi.Builder()
        .add(IconTypeAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    fun coursesService(): CoursesService = retrofit.create(CoursesService::class.java)
}