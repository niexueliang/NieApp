package com.nie.nieapp.dagger.case3

import com.nie.nieapp.dagger.Car
import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */
@Module(subcomponents = [SonComponent::class])
class ManModule {
    @Provides
    fun provideCar(): Car {
        return Car()
    }
}