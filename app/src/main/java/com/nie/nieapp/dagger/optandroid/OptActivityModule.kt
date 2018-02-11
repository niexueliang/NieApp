package com.nie.nieapp.dagger.optandroid

import android.content.Context
import android.content.SharedPreferences
import com.nie.nieapp.dagger.normal.Student
import com.xly.netservice.net.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Named


/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class OptActivityModule {

    @Provides
    fun provideName(): String {
        return "OptActivityModule"
    }

    @Provides
    fun provideStudent(): Student {
        return Student("aaa")
    }
    //这里的context直接有application提供
    @Provides
    @Named("opt")
    fun provideOptSp(@Named("applicationContext") context: Context): SharedPreferences {
        return context.getSharedPreferences("opt", Context.MODE_PRIVATE)
    }
}