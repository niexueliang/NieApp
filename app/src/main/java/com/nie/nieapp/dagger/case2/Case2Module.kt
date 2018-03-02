package com.nie.nieapp.dagger.case2

import com.nie.nieapp.dagger.Car
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

/**
 * 说明：使用scop注解了方法，那么这个module对应的component也必须使用相同的scop注解
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
@Module
class Case2Module(val activity: Case2Activity) {
    @Provides
//    @MyScope
//    @Singleton
    @Reusable
    fun provideDog(): Car {
        return Car()
    }
}