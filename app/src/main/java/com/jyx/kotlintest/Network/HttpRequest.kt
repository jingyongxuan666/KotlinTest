package com.jyx.kotlintest.Network

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HttpRequest<T> {


    var progressDialog: ProgressDialog? = null


    fun get(context:Context,call: Call<T>,httpCallback: HttpCallback<T>) {

        progressDialog = ProgressDialog(context)
        progressDialog!!.setMessage("loading...")
        progressDialog!!.show()
        call.enqueue(object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                progressDialog!!.hide()
                httpCallback.onSuccess(call,response)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                progressDialog!!.hide()
                httpCallback.onError(call,t)
            }
        })
    }



}