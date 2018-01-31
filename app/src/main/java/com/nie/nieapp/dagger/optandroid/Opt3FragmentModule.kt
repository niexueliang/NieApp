package com.nie.nieapp.dagger.optandroid

import com.nie.nieapp.dagger.normal.Student
import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
@Module
class Opt3FragmentModule {
    @Provides
    fun provideStudent(): Student {
        return Student("Opt3FragmentModule")
    }
}