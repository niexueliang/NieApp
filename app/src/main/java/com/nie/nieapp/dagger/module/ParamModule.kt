package com.nie.nieapp.dagger.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Administrator on 2018/1/7.
 */
@Module
class ParamModule{

    @Provides @Named("nxl")
    fun provideModuleParamNxl()=ModuleParam("niexueliang")

    @Provides @Named("xx")
    fun provideModuleParamXx()=ModuleParam("xiongyaqiong")
}