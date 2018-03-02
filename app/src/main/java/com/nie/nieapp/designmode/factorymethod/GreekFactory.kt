package com.nie.nieapp.designmode.factorymethod

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class GreekFactory : Factory() {
    override fun createPizza() {
        GreekPizza().all()
    }
}