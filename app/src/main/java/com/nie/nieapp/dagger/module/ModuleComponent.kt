package com.nie.nieapp.dagger.module

import com.nie.nieapp.dagger.Dagger2Activity
import dagger.Component

/**
 * Created by Administrator on 2018/1/7.
 */
@Component(modules = [NoParamModule::class,ParamModule::class])
interface ModuleComponent {
    fun inject2(activity: Dagger2Activity)
}