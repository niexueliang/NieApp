package com.xly.netservice.rxjava2

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * 说明：do方法的所在的线程，是由上一个线程切换器(observeOn、subscribeOn)决定
 * Created by code_nil on 2017/12/26.
 */
object DoMethodDemo {
    fun doMethodDemo() {
        var Tag = "DoMethodDemo"
        Observable
                .just(1)
                .doOnNext { Log.e(Tag, "doOnNext") }
                .doOnComplete { Log.e(Tag, "doOnComplete") }
                .doOnError { Log.e(Tag, "doOnError") }
                .doOnTerminate { Log.e(Tag, "doOnTerminate") }
                .doOnEach { Log.e(Tag, "doOnEach") }
                .doOnSubscribe { Log.e(Tag, "doOnSubscribe") }
                .doAfterNext { Log.e(Tag, "doAfterNext") }
                .doAfterTerminate { Log.e(Tag, "doAfterTerminate") }
                .doFinally { Log.e(Tag, "doFinally") }
//                .doOnRequest { Log.e(Tag, "doOnRequest") }
//                .doOnCancel { Log.e(Tag, "doOnCancel") }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        Log.e(Tag, "receive--->onSubscribe")
                    }

                    override fun onNext(t: Int) {
                        Log.e(Tag, "receive--->$t")
                    }

                    override fun onComplete() {
                        Log.e(Tag, "receive--->onComplete")
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Tag, "receive--->onError")
                    }

                })
    }
}