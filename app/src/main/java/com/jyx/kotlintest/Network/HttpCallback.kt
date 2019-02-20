package com.jyx.kotlintest.Network

import retrofit2.Call
import retrofit2.Response

interface HttpCallback<T> {
    fun onSuccess(call: Call<T>,response: Response<T>)
    fun onError(call: Call<T>, t: Throwable)
}