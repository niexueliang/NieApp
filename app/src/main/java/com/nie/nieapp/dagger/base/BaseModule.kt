package com.nie.nieapp.dagger.base

import com.nie.nieapp.dagger.optandroid.OptActivity
import com.nie.nieapp.dagger.optandroid.OptActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 说明：所有的activity/fragment和相应的module都在这里建立关联
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module(subcomponents = [BaseComponent::class])
abstract class BaseModule {
    @ContributesAndroidInjector(modules = [OptActivityModule::class])
    abstract fun contributeOptActivity(): OptActivity
}