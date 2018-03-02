package com.nie.nieapp.dagger.case3

import com.nie.nieapp.dagger.Car
import dagger.Component

/**
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */
@Component(modules = [ManModule::class])
interface ManComponent {
    fun inject(man: Man)

    //当Car构造被@injct注解，那么不用显示的提供Car函数，当没有被@inject注解时，必须显式的提供一个的Car的方法
//    fun car():Car

    // 用来创建 Subcomponent
    fun sonComponent(): SonComponent.Builder
}