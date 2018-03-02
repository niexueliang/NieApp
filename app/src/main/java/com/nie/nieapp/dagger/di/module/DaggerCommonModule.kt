package com.nie.nieapp.dagger.di.module

import com.nie.nieapp.dagger.da.DaggerCommonActivity
import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/3/2.
 * 君子自强不息
 */
@Module
class DaggerCommonModule {
    @Provides
    fun provideName(): String {
        return DaggerCommonActivity::class.java.name
    }
}