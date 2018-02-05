package com.xly.netservice.net

import android.content.Context
import com.nie.nieapp.net.NetWorkUtil
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * 说明：网络策略说明
 * Created by code_nil on 2017/12/22.
 */
object OkhttpStrategy {
    //设缓存有效期为两天
    val CACHE_STALE_SEC = (60 * 60 * 24 * 2).toLong()
    //http网络连接
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        var logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    //增加缓存
    fun cacheStrategy(context: Context): Cache {
        val path = context.cacheDir
        val cacheFile = File(path, "cache")
        return Cache(cacheFile, 1024 * 1024 * 100) //100Mb
    }

    //增加头部信息拦截器
    fun headerInterceptor(): Interceptor {
        return Interceptor {
            val build = it.request().newBuilder()
                    .addHeader("Content-Type", "application/json")//设置允许请求json数据
                    .build()
            it.proceed(build)
        }
    }

    //云端响应头拦截器，用来配置缓存策略
    fun mRewriteCacheControlInterceptor(context: Context) = Interceptor {
        var request = it.request()
        if (NetWorkUtil.networkState(context) != 0) {//设定在网络状态下强制缓存
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        val originalResponse = it.proceed(request)

        if (NetWorkUtil.networkState(context) != 0) {
            //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
            val cacheControl = request.cacheControl().toString()
            originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build()
        } else {
            //无网络时
            originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                    .removeHeader("Pragma")
                    .build()
        }
    }
}