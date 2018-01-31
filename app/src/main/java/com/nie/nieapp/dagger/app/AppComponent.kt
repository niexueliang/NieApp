package com.nie.nieapp.dagger.app

import dagger.Component
import android.content.SharedPreferences
import javax.inject.Singleton


/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
        fun inject(app: App)
    fun sharedPreferences(): SharedPreferences

    fun myApplication(): App

}