package com.nie.nieapp

import com.nie.nieapp.coroutine.Basics
import org.junit.Test

/**
 * 说明：
 * Created by code_nil on 2018/4/3.
 * 君子自强不息
 */
class CoroutineTest {
    @Test
    fun testBasics_launchDemo() {
//        Basics.launchDemo()
    }

    @Test
    fun testBasics_blockingDemo() {
//        Basics.blockingDemo()
    }

    @Test
    fun testBasics_jobDemo() {
//        Basics.joinDemo()
    }

    @Test
    fun testBasics_lightWeightDemo() {
//        Basics.lightWeightDemo()
    }

    @Test
    fun testBasics_repeatDemo() {
//        Basics.repeatDemo()
    }
    @Test
    fun testBasics_cancleDemo(){
//        Basics.cancleDemo()
    }
    @Test
    fun testBasics_cancelAndJoinDemo(){
        Basics.cancelAndJoinDemo()
    }
}