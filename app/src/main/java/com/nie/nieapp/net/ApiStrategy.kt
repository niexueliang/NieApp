package com.xly.netservice.net

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 说明：
 * Created by code_nil on 2017/12/22.
 */
object ApiStrategy {
    private val BASE_URL = "https://api.douban.com/v2/movie/"
    //读超时长，单位：毫秒
    private val READ_TIME_OUT = 7676L
    //连接时长，单位：毫秒
    private val CONNECT_TIME_OUT = 7676L
    //设缓存有效期为两天
    private val CACHE_STALE_SEC = (60 * 60 * 24 * 2).toLong()
    val getApiService = strategy()

    private fun strategy(): ApiService {
        //缓存
//        val cacheFile = File(Application().applicationContext.cacheDir, "cache")
//        val cache = Cache(cacheFile, 1024 * 1024 * 100) //100Mb

        //okhttp客户端
        var client = OkHttpClient
                .Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mLogInterceptor())
//                .addInterceptor(mRewriteCacheControlInterceptor())
//                .addNetworkInterceptor(mRewriteCacheControlInterceptor())
//                .addInterceptor(mHeaderInterceptor())
//                .cache(cache)
                .build()

        var retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//请求数据结果转换
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//请求返回 适配RxJava2.0
                .build()
        return retrofit.create(ApiService::class.java)
    }

    //云端响应头拦截器，用来配置缓存策略
//    private fun mRewriteCacheControlInterceptor() = Interceptor {
//        var request = it.request()
//        var cacheControl = request.cacheControl().toString()
//        //当网络不存在时
//        var cpntrol = if (TextUtils.isEmpty(cacheControl)) {
//            CacheControl.FORCE_NETWORK
//        } else {
//            CacheControl.FORCE_CACHE
//        }
//        if (!NetworkUtil.getState()) {
//            request.newBuilder().cacheControl(cpntrol)
//        }
//        val originalResponse = it.proceed(request)
//        if (!NetworkUtil.getState()) {
//            originalResponse.newBuilder()
//                    .header("Cache-Control", cacheControl)
//                    .removeHeader("Pragma")
//                    .build()
//        } else {
//            originalResponse.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
//                    .removeHeader("Pragma")
//                    .build()
//        }
//    }

    //日志拦截器
    private fun mLogInterceptor(): HttpLoggingInterceptor {
        var logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    //增加头部信息拦截器
//    private fun mHeaderInterceptor() = Interceptor {
//        val build = it.request().newBuilder()
//                .addHeader("Content-Type", "application/json")//设置允许请求json数据
//                .build()
//        it.proceed(build)
//    }
}