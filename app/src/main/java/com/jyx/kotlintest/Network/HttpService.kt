package com.jyx.kotlintest.Network

import com.jyx.kotlintest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object HttpService {
    private val BASE_URL = "https://api.imgur.com/3/gallery/"
    val provider = getInstance()
    private fun getInstance(): ApiService? {
        return buildRetrofit()!!.create(ApiService::class.java)
    }

    private fun buildRetrofit(): Retrofit? {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .connectTimeout(10000, TimeUnit.SECONDS)
                .build()



        return Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


}