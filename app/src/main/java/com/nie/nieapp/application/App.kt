package com.nie.nieapp.application

import android.app.Application

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this   //初始化instance
        DaggerAppComponent.builder().appModule(AppModule(instance)).build()
    }

    companion object {
        //延迟初始化
        @JvmStatic
        lateinit var instance: App
            private set
    }
}