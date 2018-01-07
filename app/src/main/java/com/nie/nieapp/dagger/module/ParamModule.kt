package com.nie.nieapp.dagger.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Administrator on 2018/1/7.
 */
@Module
class ParamModule{

    @Provides
    fun provideModuleParamNie()=ModuleParam(ModuleBean("niexueliang","man"))


}