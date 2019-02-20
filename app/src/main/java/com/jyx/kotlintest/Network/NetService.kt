package com.jyx.kotlintest.Network

import com.jyx.kotlintest.Model.ImagesBean
import retrofit2.Call
import retrofit2.http.GET

interface NetService {
    @GET("hot/time/0?IMGURPLATFORM=web&SESSIONCOUNT=1&client_id=546c25a59c58ad7&realtime_results=false&showViral=true")
    fun getImages() : Call<ImagesBean>
}