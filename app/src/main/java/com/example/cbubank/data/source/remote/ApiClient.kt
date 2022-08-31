package com.example.cbubank.data.source.remote

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.cbubank.App
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(ChuckerInterceptor.Builder(App.instance).build())
        .build()

    val retrofit =Retrofit.Builder()
        .baseUrl("http://cbu.uz/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}