package com.nie.nieapp.dagger.base

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
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
    @Named("default")
    fun provideDefaultSharedPrefrence(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app.applicationContext)
    }

    @Provides
    fun provideApp(): App {
        return app
    }

    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }
}