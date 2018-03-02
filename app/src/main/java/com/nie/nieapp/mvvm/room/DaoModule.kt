package com.nie.nieapp.mvvm.room

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
@Module
class DaoModule {
    @Provides
    fun provideDao(@Named("applicationContext") context: Context): UserDao {
        return context.databases().userDao()
    }
}