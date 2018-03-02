package com.nie.nieapp.designmode.AbstractFactory

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class FamilyFactory:Factory{
    override fun createHamburger(): Hamburger {
        return FamilyHamburger()
    }

    override fun createPizza(): Pizza {
        return FamilyPizza()
    }

}