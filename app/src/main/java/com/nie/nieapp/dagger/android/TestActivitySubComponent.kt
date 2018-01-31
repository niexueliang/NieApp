package com.nie.nieapp.dagger.android

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.nie.nieapp.dagger.normal.Student
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Named

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Subcomponent(modules = [AndroidInjectionModule::class, TestActivitySubComponent.SubModule::class])
interface TestActivitySubComponent : AndroidInjector<TestActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TestActivity>()

    @Module
    class SubModule {
        @Provides
        fun provideStudent(): Student {
            return Student("王二小")
        }


    }
}