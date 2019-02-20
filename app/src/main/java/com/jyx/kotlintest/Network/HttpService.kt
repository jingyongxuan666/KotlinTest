package com.jyx.kotlintest.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object HttpService {
    private val BASE_URL = "https://api.imgur.com/3/gallery/"
    val provider = getInstance()
    private fun getInstance(): ApiService? {
        return buildRetrofit()!!.create(ApiService::class.java)
    }

    private fun buildRetrofit(): Retrofit? {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}