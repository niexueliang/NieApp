package com.nie.nieapp.dagger.module

import dagger.Component

/**
 * Created by Administrator on 2018/1/7.
 */
@Component(modules = arrayOf(ParamModule::class))
interface ModuleComponent {
    fun inject2(activity: Dagger2Activity)
}