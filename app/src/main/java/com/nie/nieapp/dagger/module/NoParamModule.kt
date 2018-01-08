package com.nie.nieapp.dagger.module

import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/1/7.
 */
@Module
class NoParamModule{
    @Provides
    fun provideModuleNoParam()=ModuleNoParam()
}