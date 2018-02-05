package com.nie.nieapp.net

import android.content.Context
import com.xly.netservice.net.ApiService
import com.xly.netservice.net.OkhttpStrategy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
@Module
class ApiModule {
    val BASE_URL = "https://api.douban.com/v2/movie/"
    //读超时长，单位：毫秒
    val READ_TIME_OUT = 7676L
    //连接时长，单位：毫秒
    val CONNECT_TIME_OUT = 7676L

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//请求数据结果转换
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//请求返回 适配RxJava2.0
                .build().create(ApiService::class.java)
    }


    @Provides
    fun provideClient(context: Context): OkHttpClient {
        return OkHttpClient
                .Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(OkhttpStrategy.httpLoggingInterceptor())
//                .addInterceptor(OkhttpStrategy.mRewriteCacheControlInterceptor(context))
//                .addNetworkInterceptor(OkhttpStrategy.mRewriteCacheControlInterceptor(context))
//                .addInterceptor(OkhttpStrategy.headerInterceptor())
//                .cache(OkhttpStrategy.cacheStrategy(context))
                .build()
    }
}