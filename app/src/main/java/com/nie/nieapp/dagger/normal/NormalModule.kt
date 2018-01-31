package com.nie.nieapp.dagger.normal

import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module
class NormalModule(val na: NormalActivity) {
    @Provides
    @ActivityScope//添加注解实现局部单例
    fun provideStudent(): Student {
        return Student("xxx")
    }
}