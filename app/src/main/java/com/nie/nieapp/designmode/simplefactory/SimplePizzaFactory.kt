package com.nie.nieapp.designmode.simplefactory

import com.nie.nieapp.designmode.factorymethod.CheesePizza
import com.nie.nieapp.designmode.factorymethod.GreekPizza

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
class SimplePizzaFactory {
    fun createPizza(type: String) {
        when (type) {
            "cheese" -> {
                CheesePizza().all()
            }
            "greek" -> {
                GreekPizza().all()
            }
        }
    }
}