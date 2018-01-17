package com.nie.nieapp.dagger.case1

import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/1/9.
 * 君子自强不息
 */
@Module
class OrangeModule(val orangeBean: OrangeBean) {
    @Provides
    fun provideOrangeBean(): OrangeBean {
        return orangeBean
    }
}