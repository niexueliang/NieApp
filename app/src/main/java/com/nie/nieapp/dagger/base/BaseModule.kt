package com.nie.nieapp.dagger.base

import com.nie.nieapp.dagger.optandroid.*
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

    @ContributesAndroidInjector(modules = [Opt2ActivityModule::class])
    abstract fun contributeOpt2Activity(): Opt2Activity

    @ContributesAndroidInjector(modules = [Opt3FragmentModule::class])
    abstract fun contributeOpt3FragmentModule(): Opt3Fragment
}