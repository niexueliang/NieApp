package com.nie.nieapp.coroutine

import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*
import kotlin.concurrent.thread

/**
 * 说明：
 * Created by code_nil on 2018/4/3.
 * 君子自强不息
 */
object Basics {
    fun launchDemo() {
        launch {
            // launch new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues while coroutine is delayed
        Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
        println("end")
    }

    fun blockingDemo() {
        launch {
            // launch new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main thread continues here immediately
        //runBlocking 类似 Thread.sleep用于阻塞主线程
        runBlocking {
            // but this expression blocks the main thread
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        println("end")
    }

    fun joinDemo() = runBlocking {
        val job = launch {
            println("World!")
        }
        job.join()
        println("Hello,")
    }

    fun lightWeightDemo() = runBlocking {
        val jobs = List(100_000) {
            // launch a lot of coroutines and list their jobs
            launch {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() } // wait for all jobs to complete
    }

    //活动的协程并不能保证进程存活
    fun repeatDemo() = runBlocking {
        val job = launch {
            repeat(1000) {
                println("I'm sleeping $it ...")
                delay(500L)
            }
        }
        job.join()
        println("END")
//        delay(1500L) // just quit after delay
    }

    fun cancleDemo()= runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        job.join() // waits for job's completion
        println("main: Now I can quit.")
    }

    fun cancelAndJoinDemo() {
//        val startTime = System.currentTimeMillis()
//        val job = launch {
//            var nextPrintTime = startTime
//            var i = 0
//            while (i < 100) { // computation loop, just wastes CPU
//                // print a message twice a second
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    println("I'm sleeping ${i++} ...")
//                    nextPrintTime += 500L
//                }
//            }
//        }
//        delay(1300L) // delay a bit
//        println("main: I'm tired of waiting!")
//        job.cancelAndJoin() // cancels the job and waits for its completion
//        println("main: Now I can quit.")
        val temp=LinkedList<Int>()
        temp.add(1)
        temp.add(2)
        temp.add(3)
        println(temp)
        temp.removeFirst()
        println(temp)
        temp.add(4)
        println(temp)
    }
}