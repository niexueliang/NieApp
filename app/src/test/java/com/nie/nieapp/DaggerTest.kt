package com.nie.nieapp

import com.nie.nieapp.dagger.case3.Friend
import com.nie.nieapp.dagger.case3.Man
import com.nie.nieapp.dagger.case3.Son
import org.junit.Test

/**
 * 说明：
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */
class DaggerTest {
    @Test
    fun testDependCmponent() {
        val friend = Friend()
        friend.printCar()
    }


    @Test
    fun testSubComponent(){
        val son=Son()
        son.printCar()
    }
}