package com.nie.nieapp.designmode.factorymethod

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class CheesePizza : Pizza(), AnkoLogger {
    override fun all() {
        prepare()
        bake()
        cut()
        box()
    }

    override val loggerTag: String
        get() = "CheesePizza"

    override fun prepare() {
        error { "CheesePizza prepare" }
    }

    override fun bake() {
        error { "CheesePizza bake" }
    }

    override fun cut() {
        error { "CheesePizza cut" }
    }

    override fun box() {
        error { "CheesePizza box" }
    }

}