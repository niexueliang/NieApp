package com.nie.nieapp.designmode.AbstractFactory

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class SingleHamburger : Hamburger(), AnkoLogger {
    override val loggerTag: String
        get() = "SingleHamburger"

    override fun create() {
        error { "单人Hamburger" }
    }
}