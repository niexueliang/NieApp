package com.nie.nieapp.glide

import android.content.Context
import android.graphics.Bitmap
import android.support.annotation.NonNull
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest


/**
 * 说明：
 * Created by code_nil on 2017/12/29.
 */
class GlideBlurformation(private val context: Context) : BitmapTransformation() {
    override fun transform(@NonNull pool: BitmapPool, @NonNull toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
        return BlurBitmapUtil.blurBitmap(context, toTransform, 20f, outWidth, outHeight)
    }

    override  fun updateDiskCacheKey(messageDigest: MessageDigest) {}
}