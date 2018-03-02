package com.nie.nieapp.dagger.di.module

import android.content.Context
import com.nie.nieapp.dagger.base.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class AppModule(val app: BaseApp) {

    @Provides
    fun provideApp(): BaseApp {
        return app
    }

    @Provides
    @Named("applicationContext")
    fun provideContext(): Context {
        return app.applicationContext
    }

}