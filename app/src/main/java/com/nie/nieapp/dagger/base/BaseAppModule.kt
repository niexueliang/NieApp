package com.nie.nieapp.dagger.base

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nie.nieapp.dagger.base.BaseApp
import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class BaseAppModule(val app: BaseApp) {
    @Provides
    fun provideSharedPrefrence(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app.applicationContext)
    }

    @Provides
    fun provideOptApp(): BaseApp {
        return app
    }

}