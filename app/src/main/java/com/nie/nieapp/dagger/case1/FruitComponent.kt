package com.nie.nieapp.dagger.case1

import dagger.Component

/**
 * 说明：
 * Created by code_nil on 2018/1/9.
 * 君子自强不息
 */
@Component(modules = [FruitModule::class])
interface FruitComponent {
    fun inject(activity: Case1Activity)

    fun makeApple(): AppleBean//直接提供对象实例
}