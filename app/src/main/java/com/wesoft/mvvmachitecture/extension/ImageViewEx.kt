package com.wesoft.mvvmachitecture.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * Created by james on 2018/8/24.
 */

fun ImageView.load(path: String?) {
    val options = RequestOptions()
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
    Glide.with(context)
            .asBitmap() //gif 以静态图显示
            .load(path)
            .apply(options)
            .into(this)
}

fun ImageView.load(path: String?, placeholder: Int) {
    val options = RequestOptions()
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(placeholder)
            .error(placeholder)
    Glide.with(context)
            .asBitmap() //gif 以静态图显示
            .load(path)
            .apply(options)
            .into(this)
}
