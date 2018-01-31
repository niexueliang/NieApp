package com.nie.nieapp.dagger.optandroid

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nie.nieapp.dagger.normal.Student
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class Opt2ActivityModule {
    @Provides
    fun provideName(): String {
        return "Opt2ActivityModule"
    }

    @Provides
    fun provideStudent(): Student {
        return Student("Opt2ActivityModule")
    }

}