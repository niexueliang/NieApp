package com.nie.nieapp.receiver

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context

/**
 * 说明：
 * Created by code_nil on 2018/2/11.
 * 君子自强不息
 */
class ReceiverCycle(val context: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        ReceiverDemo.localRegist(context)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        ReceiverDemo.localUnRegist(context)
    }
}