package com.jyx.kotlintest

import android.app.ProgressDialog
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.jyx.kotlintest.Adapter.ImgAdapter
import com.jyx.kotlintest.Model.Data
import com.jyx.kotlintest.Model.ImagesBean
import com.jyx.kotlintest.Network.NetService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/gallery/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val netService = retrofit.create(NetService::class.java)
        progress_bar.visibility = View.VISIBLE
        netService.getImages().enqueue(object : Callback<ImagesBean>{
            override fun onFailure(call: Call<ImagesBean>, t: Throwable) {
                Log.d("test",t.message)
                progress_bar.visibility = View.GONE
                Toast.makeText(this@MainActivity,"net is poor",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ImagesBean>, response: Response<ImagesBean>) {

                var imagesBean:ImagesBean? = response!!.body()
                var imgList :List<Data> = imagesBean!!.data
                rvImages.layoutManager = GridLayoutManager(this@MainActivity,2)
                rvImages.adapter = ImgAdapter(this@MainActivity,imgList)
                progress_bar.visibility = View.GONE
            }

        })




    }
}
