package com.nie.nieapp.designmode.AbstractFactory

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class SingleFactory:Factory{
    override fun createPizza(): Pizza {
        return SinglePizza()
    }

    override fun createHamburger(): Hamburger {
        return SingleHamburger()
    }
}