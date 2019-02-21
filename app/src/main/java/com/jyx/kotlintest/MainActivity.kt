package com.jyx.kotlintest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jyx.kotlintest.Adapter.ImgAdapter
import com.jyx.kotlintest.Model.Data
import com.jyx.kotlintest.Model.ImagesBean
import com.jyx.kotlintest.Model.ImagesVIewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imgsViewModel: ImagesVIewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgsViewModel = ViewModelProviders.of(this).get(ImagesVIewModel::class.java)
        imgsViewModel!!.getData(this).observe(this, object : Observer<ImagesBean> {
            override fun onChanged(imagesBean: ImagesBean?) {

                var imgList :List<Data> = imagesBean!!.data
                rvImages.layoutManager = GridLayoutManager(this@MainActivity,2) as RecyclerView.LayoutManager?
                rvImages.adapter = ImgAdapter(this@MainActivity,imgList)
                rvImages.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        if (newState == RecyclerView.SCROLL_STATE_IDLE){
                            Glide.with(this@MainActivity).resumeRequests()
                        }else{
                            Glide.with(this@MainActivity).pauseRequests()
                        }
                    }
                })
            }

        })


    }
}
