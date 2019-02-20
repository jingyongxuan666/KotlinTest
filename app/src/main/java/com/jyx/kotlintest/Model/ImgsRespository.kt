package com.jyx.kotlintest.Model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.jyx.kotlintest.Network.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImgsRespository constructor(context: Context) {


    private val context:Context?=context

    fun getIagesList():LiveData<ImagesBean>{

        var liveData:MutableLiveData<ImagesBean> = MutableLiveData<ImagesBean>()

        HttpService.provider!!.getImages().enqueue(object : Callback<ImagesBean>{
            override fun onFailure(call: Call<ImagesBean>, t: Throwable) {
            }

            override fun onResponse(call: Call<ImagesBean>, response: Response<ImagesBean>) {
                liveData.value = response.body()
            }
        })
        return liveData
    }

    private fun refreshImages(){
        var response = HttpService.provider!!.getImages().execute()
    }



}