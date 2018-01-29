package com.nie.nieapp.dagger.android

import android.content.Context
import android.content.SharedPreferences

import com.nie.nieapp.MainActivity

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */

@Subcomponent(modules = [AndroidInjectionModule::class,YourActivitySubcomponent.SubModule::class])
interface YourActivitySubcomponent : AndroidInjector<FirstActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<FirstActivity>()

    @Module
    class SubModule {

        @Provides
        internal fun provideName(): String {
            return MainActivity::class.java.name
        }


        @Provides
        internal fun provideSp(activity: MainActivity): SharedPreferences {
            return activity.getSharedPreferences("def", Context.MODE_PRIVATE)
        }

    }
}