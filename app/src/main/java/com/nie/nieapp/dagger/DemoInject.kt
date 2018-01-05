package com.nie.nieapp.dagger

import dagger.Component
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/5.
 * 君子自强不息
 */
class A @Inject constructor(private val aa: Aa, private val aaa: Aaa) {
    fun getData() = aa.getData() + aaa.getData()
}

class Aa @Inject constructor() {
    init {
        println("Aa类初始化后，")
    }
    fun getData() = "我是Aa，我被注解生成"
}

class Aaa @Inject constructor(private val aa: Aa) {
    init {
        println("Aaa类初始化后，")
    }

    fun getData() = "在Aaa中获取到Aa的数据:" + aa.getData()
}

class B {
    @Inject lateinit var a: A

    init {
        DaggerABComponent.create().Inject(this)
    }

    fun getData() = a.getData()
}

@Component
interface ABComponent {
    fun Inject(b: B)
}
