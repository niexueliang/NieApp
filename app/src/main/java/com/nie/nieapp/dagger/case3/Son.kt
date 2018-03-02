package com.nie.nieapp.dagger.case3

import com.nie.nieapp.dagger.Car
import javax.inject.Inject

/**
 * 说明：依赖继承
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */

class Son {
    @Inject
    lateinit var car: Car

    init {
        val manComponent=DaggerManComponent.builder().build()
        manComponent.sonComponent().build().inject(this)
    }

    fun printCar() {
        println("name::::${car.name}")
    }
}