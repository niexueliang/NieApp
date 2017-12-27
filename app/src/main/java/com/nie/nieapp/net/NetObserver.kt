package com.xly.netservice.net

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * 说明：传入一个带参数的匿名函数，这样相当于直接实现了回调
 * Created by code_nil on 2017/12/22.
 */
class NetObserver<T>(private val dataCallBack: (T) -> Unit) : Observer<T> {
    private val TAG: String = "NetObserver"
    override fun onComplete() {
        Log.d(TAG, "onComplete")
    }

    override fun onError(e: Throwable) {
        Log.d(TAG, "onError")
    }

    override fun onSubscribe(d: Disposable) {
        Log.d(TAG, "onError")
    }

    override fun onNext(t: T) {
        dataCallBack(t)
    }

}