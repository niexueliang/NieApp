package com.nie.nieapp.dagger.android

import com.nie.nieapp.dagger.normal.Student
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Subcomponent(modules = [AndroidInjectionModule::class,ADActivitySubComponent.SubModule::class])
interface ADActivitySubComponent : AndroidInjector<ADActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ADActivity>()

    @Module
    class SubModule {
        @Provides
        fun provideStudent(): Student {
            return Student("聂学良")
        }
    }
}