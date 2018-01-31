package com.nie.nieapp.dagger.normal

import com.nie.nieapp.dagger.app.AppComponent
import dagger.Component

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@ActivityScope//添加注解实现局部单例
@Component(modules = [NormalModule::class],dependencies = [AppComponent::class])
interface NormalComponent {
    fun inject(na: NormalActivity)
}