package com.nie.nieapp.dagger.base

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nie.nieapp.dagger.base.App
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class AppModule(val app: App) {

    @Provides
    fun provideApp(): App {
        return app
    }

    @Provides
    @Named("applicationContext")
    fun provideContext(): Context {
        return app.applicationContext
    }

}