package com.jyx.kotlintest.Model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.jyx.kotlintest.Network.HttpCallback
import com.jyx.kotlintest.Network.HttpRequest
import com.jyx.kotlintest.Network.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesVIewModel :  ViewModel() {

    private var liveImgs: MutableLiveData<ImagesBean>? = null

    fun getData(context: Context):MutableLiveData<ImagesBean>{
        if (liveImgs == null){
            liveImgs = MutableLiveData<ImagesBean>()
        }

        HttpRequest<ImagesBean>().get(context,HttpService.provider!!.getImages(), object : HttpCallback<ImagesBean> {
            override fun onSuccess(call: Call<ImagesBean>, response: Response<ImagesBean>) {
                liveImgs!!.value = response.body()
            }

            override fun onError(call: Call<ImagesBean>, t: Throwable) {
            }

        })
        return this.liveImgs!!
    }



}