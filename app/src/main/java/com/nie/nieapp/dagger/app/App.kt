package com.nie.nieapp.dagger.app

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
//import com.nie.nieapp.application.DaggerAppComponent
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
class App : Application() {

    @Inject
    lateinit var sp: SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this   //初始化instance
        val appComponent = DaggerAppComponent.builder().appModule(AppModule(instance)).build()
        ComponentHolder.myAppComponent = appComponent
        appComponent.inject(this)
        val result = sp.edit().putString("app", "App").commit()
        Log.e("app", "$result")
    }

    companion object {
        //延迟初始化
        @JvmStatic
        lateinit var instance: App
            private set
    }
}