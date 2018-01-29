package com.nie.nieapp.application

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp(): App {
        return app
    }
}