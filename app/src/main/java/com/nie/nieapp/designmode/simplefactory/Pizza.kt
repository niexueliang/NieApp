package com.nie.nieapp.designmode.simplefactory

/**
 * 说明：
 * Created by code_nil on 2018/2/22.
 * 君子自强不息
 */
open abstract class Pizza {
    abstract fun prepare()
    abstract fun bake()
    abstract fun cut()
    abstract fun box()
    abstract fun all()
}