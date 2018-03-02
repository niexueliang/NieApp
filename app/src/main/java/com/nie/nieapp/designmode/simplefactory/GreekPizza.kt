package com.nie.nieapp.designmode.simplefactory

import com.nie.nieapp.designmode.factorymethod.Pizza
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class GreekPizza : Pizza(),AnkoLogger {
    override val loggerTag: String
        get() = "GreekPizza"
    override fun prepare() {
        error { "GreekPizza prepare" }
    }

    override fun bake() {
        error { "GreekPizza bake" }
    }

    override fun cut() {
        error { "GreekPizza cut" }
    }

    override fun box() {
        error { "GreekPizza box" }
    }

    override fun all() {
        prepare()
        bake()
        cut()
        box()
    }
}