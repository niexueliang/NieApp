package com.nie.nieapp.glide

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.nie.nieapp.R
import com.nie.nieapp.databinding.ActivityGlideBinding
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=DataBindingUtil.setContentView<ActivityGlideBinding>(this, R.layout.activity_glide)
        GlideApp
                .with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514548592102&di=507144449d0154a5f50b530b42755d3d&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F83025aafa40f4bfb4d9e989e0a4f78f0f63618a9.jpg")
                .apply(RequestOptions().optionalTransform(GlideBlurformation(this)))//变换
                .transition(DrawableTransitionOptions.withCrossFade())//过度
                .centerCrop()
                .transform(RoundedCorners(10))
                .placeholder(R.mipmap.ic_launcher)//占位图
                .error(ColorDrawable(Color.RED))//请求图片加载错误
                .fallback(ColorDrawable(Color.GRAY))//请求url/model为空
                .into(binding.agIv)

    }
}
