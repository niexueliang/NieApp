package com.nie.nieapp.dagger.base

import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
@Subcomponent(modules = [AndroidInjectionModule::class])
interface BaseComponent : AndroidInjector<Any> {
    //这里不指定类型，所以不转化为kotlin
    //每一个继承BaseActivity/BaseFragmnent的Activity/Fragment，都共享同一个SubComponent
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<Any>()
}
