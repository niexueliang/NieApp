package com.nie.nieapp.glide

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.nie.nieapp.R
import com.nie.nieapp.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {
    //http://d.hiphotos.baidu.com/image/pic/item/a044ad345982b2b713b5ad7d3aadcbef76099b65.jpg
    //    http://uppic.fd.zol-img.com.cn/t_s640x2000/g5/M00/0F/04/ChMkJlhiA6aIbmSrAAPmCUt7OrYAAY5tQOf_YQAA-Yh757.gif
//    http://img.mp.itc.cn/upload/20161116/fc10ee2abef545c7bbd6f46a09c20ed2_th.gif
    //http://up.enterdesk.com/edpic_source/a7/0a/cd/a70acddb2589bcd94261926a392d09f1.jpg
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        var binding = DataBindingUtil.setContentView<ActivityGlideBinding>(this, R.layout.activity_glide)
        binding.agIv.setOnClickListener {
            GlideApp
                    .with(this)
                    .load("http://up.enterdesk.com/edpic_source/a7/0a/cd/a70acddb2589bcd94261926a392d09f1.jpg")
                    .apply(RequestOptions().optionalTransform(BlurTransformation(this)))//变换
                    .transition(DrawableTransitionOptions.withCrossFade())//过度
                    .centerCrop()
                    .transform(RoundedCorners(10))
                    .placeholder(R.mipmap.ic_launcher)//占位图
                    .error(ColorDrawable(Color.RED))//请求图片加载错误
                    .fallback(ColorDrawable(Color.GRAY))//请求url/model为空
                    .into(binding.agIv)
        }
    }
}
