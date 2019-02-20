package com.jyx.kotlintest.Adapter

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jyx.kotlintest.Model.Data
import com.jyx.kotlintest.R

class ImgAdapter(context: Context?, list: List<Data>?) : RecyclerView.Adapter<ImgAdapter.ImgViewHolder>() {
    private var context:Context? = context
    private var list: List<Data>? = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false)
        return ImgViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: ImgViewHolder, position: Int) {
        //loading animation
        val anim : ObjectAnimator = ObjectAnimator.ofInt(holder.imageView,"ImageLevel",0,10000)
        anim.duration = 800
        anim.repeatCount = ObjectAnimator.INFINITE
        anim.start()

        var imageInfo = list!![position].images
        if (imageInfo != null){
            Glide.with(context!!).load(list!![position].images[0].link)
                    .placeholder(R.drawable.loading).listener(object: RequestListener<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            anim.cancel()
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            anim.cancel()
                            return false
                        }
                    }).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView)
            holder.txtDesc.text = list!![position].images[0].description
        }


    }


    class ImgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView : ImageView = itemView.findViewById(R.id.image)
        var txtDesc: TextView = itemView.findViewById(R.id.text)
    }

}