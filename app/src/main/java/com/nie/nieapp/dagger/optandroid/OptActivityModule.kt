package com.nie.nieapp.dagger.optandroid

import com.nie.nieapp.dagger.normal.Student
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
}