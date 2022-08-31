package com.example.cbubank.data.source.remote

import com.example.cbubank.data.models.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface CbuApi {
    @GET("/uzc/arkhiv-kursov-valyut/json/")
    fun getAllValyuts():Call<List<ResponseData>>
}