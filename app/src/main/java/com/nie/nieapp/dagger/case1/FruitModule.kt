package com.nie.nieapp.dagger.case1

import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/1/9.
 * 君子自强不息
 */
@Module(includes = [OrangeModule::class])
class FruitModule() {
    @Provides
    fun provideAppleBean(): AppleBean {
        return AppleBean("红富士", 4.5f)
    }
    @Provides
    fun provideFruits(appleBean: AppleBean, orangeBean: OrangeBean): Fruits {
        return Fruits(orangeBean, appleBean)
    }
}