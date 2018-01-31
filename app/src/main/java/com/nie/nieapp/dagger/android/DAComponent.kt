package com.nie.nieapp.dagger.android

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ADActivityModule::class,
    TestActivityModule::class])
interface DAComponent {
    fun inject(dapp: DApp)
}