package com.nie.nieapp.rxjava

import android.util.Log
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * 说明：演示Rxjava2操作符 create map zip
 * Created by code_nil on 2017/12/22.
 */
object Rxjava2Demo {
    //region 创建发射器
    //create操作符，创建一个被观察者(发射器)
    fun createDemo() {
        var TAG = "create"
        var sub = Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(e: ObservableEmitter<Int>) {
                Log.e(TAG, "Observable::send->1")
                e.onNext(1)
                Log.e(TAG, "Observable::send->2")
                e.onNext(2)
                Log.e(TAG, "Observable::send->3")
                e.onNext(3)
                Log.e(TAG, "Observable::send->4")
                e.onNext(4)
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Int> {
                    override fun onError(e: Throwable) {
                        Log.e(TAG, "Observer::receive->onError")
                    }

                    override fun onComplete() {
                        Log.e(TAG, "Observer::receive->onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, "Observer::receive->onSubscribe")
                    }

                    override fun onNext(t: Int) {
                        Log.e(TAG, "Observer::receive->$t")
                    }

                })
    }

    //每次订阅都会创建一个新的Observable，并且如果没有被订阅，就不会产生新的Observable。其他的创建方式都是首先创建出了发射器
    fun deferDemo() {
        var TAG = "defer"
        Observable.defer { Observable.just(1, 2, 3) }.subscribe { Log.e(TAG, "$it") }
    }

    //将A,B事件结果组合起来，组合方式是A1B1 A2B2 ……
    //没有调用了onComplete
    fun zipDemo() {
        var TAG = "zip"
        Observable
                .zip(getZipStringObservabl(), getZipIntObservabl(), object : BiFunction<String, Int, String> {
                    override fun apply(t1: String, t2: Int): String {
                        return "$t1$t2"
                    }
                })
                .subscribe(object : Observer<String> {
                    override fun onError(e: Throwable) {
                        Log.e(TAG, "Observer::receive->onError")
                    }

                    override fun onComplete() {
                        Log.e(TAG, "Observer::receive->onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, "Observer::receive->onSubscribe")
                    }

                    override fun onNext(t: String) {
                        Log.e(TAG, "Observer::receive->$t")
                    }
                })
    }

    //concat操作符，将A,B事件按顺序合并起来，称为一个新的发射器
    //调用了onComplete
    fun concatDemo() {
        var TAG = "concat"
        Observable.concat(Observable.just(1, 2, 3, 4), Observable.just("a", "b"), Observable.just(1, 2, 3, 4), Observable.just("a", "b"))
                .subscribe(object : Observer<Any> {
                    override fun onError(e: Throwable) {
                        Log.e(TAG, "Observer::receive->onError")
                    }

                    override fun onComplete() {
                        Log.e(TAG, "Observer::receive->onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, "Observer::receive->onSubscribe")
                    }

                    override fun onNext(t: Any) {
                        Log.e(TAG, "Observer::receive->$t")
                    }
                })
    }

    //通过调用timer关键字，设置一个定时任务
    fun timerDemo() {
        var TAG = "timer"
        Observable.timer(500, TimeUnit.MILLISECONDS).subscribe(object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                Log.e(TAG, "start--->${System.currentTimeMillis()}")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError")
            }

            override fun onNext(t: Long) {
                Log.e(TAG, "end----->$t--->${System.currentTimeMillis()}")
            }

            override fun onComplete() {
                Log.e(TAG, "onComplete")
            }

        })
    }

    //定时发送，调用interval会产生一个发射者(被观察者)，将会定时发送一个数据(从0开始) 倒计时心跳等操作
    fun intervalDemo() {
        var TAG = "interval"
        Observable
                .interval(0, 1000, TimeUnit.MILLISECONDS)
                .subscribe { Log.e(TAG, "$it") }
    }

    //通过调用just关键字，创建一个发射器，发射指定数据
    fun justDemo() {
        var TAG = "just"
        Observable.just(1, 2, 3, 4).subscribe { Log.e(TAG, "$it") }
    }

    //将多个发射器结合起来，与concat不同的是，这里数据发射的先后无法得到保证
    fun mergeDemo() {
        var TAG = "first"
        Observable.merge(getZipStringObservabl(), getZipIntObservabl()).subscribe { Log.e(TAG, "$it") }
    }
    //endregion


    //在数据接收之前执行指定操作,同时不会改变数据源，doOnNext(非关键字)
    fun doOnNextDemo() {
        var TAG = "doOnNext"
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext { Log.e(TAG, "doOnNext--->保存$it") }
                .subscribe(object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, "receive--->onSubscribe")
                    }

                    override fun onNext(t: Int) {
                        Log.e(TAG, "receive--->$t")
                    }

                    override fun onComplete() {
                        Log.e(TAG, "receive--->onComplete")
                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "receive--->onError")
                    }

                })
    }


    //Single,Single是一个发射器，该发射器只会接收单一参数，同时该方法灭有onnext，但是有onSuccess
    fun singleDemo() {
        var TAG = "Single"
        Single.just(5).subscribe(object : SingleObserver<Int> {
            override fun onSuccess(t: Int) {
                Log.e(TAG, "onSuccess--> $t")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError--> $e")
            }

            override fun onSubscribe(d: Disposable) {
                Log.e(TAG, "onSubscribe")
            }

        })
    }


    //通过调用take关键字，可以指定接收多少个数据
    fun takeDemo() {
        var TAG = "take"
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS).take(10).subscribe { Log.e(TAG, "$it") }
    }

    //获取末尾的指定数量的数据
    fun takeLastDemo() {
        var TAG = "takeLast"
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS).takeLast(1, TimeUnit.SECONDS).subscribe { Log.e(TAG, "$it") }
    }

    //获取数据的第一个,当数据无法获取到的时候，那么便会发出默认参数值。(同filter连用可以产生)
    fun firstDemo() {
        var TAG = "first"
        Observable.just(1, 2, 3, 4).filter { it > 10 }.first(10).subscribe { t1, t2 -> Log.e(TAG, "$t1----$t2") }
    }

    //获取数据的最后一个,当数据无法获取到的时候，那么便会发出默认参数值。(同filter连用可以产生)
    fun lastDemo() {
        var TAG = "last"
        Observable.just(1, 2, 3, 4).filter { it > 10 }.last(999).subscribe { t1, t2 -> Log.e(TAG, "$t1----$t2") }
    }

    //通过调用skip关键字，每次发送数据都将跳过指定长度
    fun skipDemo() {
        var TAG = "skip"
        Observable.just(1, 2, 3, 4).skip(2).subscribe { Log.e(TAG, "$it") }
    }

    //去除频率过快的操作(RxAndroid的双击UI操作)，指定频率，在一个操作之后，指定大于频率才会执行，连续的操作只会执行最后一次
    fun debounceDemo() {
        var TAG = "debounce"
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            Thread.sleep(500)
            it.onNext(2)
            Thread.sleep(500)
            it.onNext(3)
            Thread.sleep(300)
            it.onNext(4)
            Thread.sleep(300)
            it.onNext(5)
        }).debounce(500, TimeUnit.MILLISECONDS).subscribe { Log.e(TAG, "$it") }
    }


    //map操作符，对发射器每次发射的数据执行处理
    //没有调用了onComplete
    fun mapDemo() {
        var TAG = "map"
        var sub = Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(e: ObservableEmitter<Int>) {
                Log.e(TAG, "Observable::send->1")
                e.onNext(1)
                Log.e(TAG, "Observable::send->2")
                e.onNext(2)
                Log.e(TAG, "Observable::send->3")
                e.onNext(3)
                Log.e(TAG, "Observable::send->4")
                e.onNext(4)
            }
        })
                .map(object : Function<Int, String> {
                    override fun apply(t: Int): String {
                        return "$t"
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<String> {
                    override fun onError(e: Throwable) {
                        Log.e(TAG, "Observer::receive->onError")
                    }

                    override fun onComplete() {
                        Log.e(TAG, "Observer::receive->onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.e(TAG, "Observer::receive->onSubscribe")
                    }

                    override fun onNext(t: String) {
                        Log.e(TAG, "Observer::receive->$t")
                    }

                })
    }

    //通过调用flatMap关键字，可以无序弹出多个被观察者（发射器）
    fun flatMapDemo() {
        var TAG = "flatMap"
        Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(e: ObservableEmitter<Int>) {
                Log.e(TAG, "Observable::send->1")
                e.onNext(1)
                Log.e(TAG, "Observable::send->2")
                e.onNext(2)
                Log.e(TAG, "Observable::send->3")
                e.onNext(3)
                Log.e(TAG, "Observable::send->4")
                e.onNext(4)
            }
        }).flatMap(object : Function<Int, ObservableSource<String>> {
            override fun apply(t: Int): ObservableSource<String> {
                var list = arrayListOf<String>()
                (0..2).mapTo(list) { "value $t ---- $it" }
                return Observable.fromIterable(list).delay(500, TimeUnit.MILLISECONDS)
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.e(TAG, "Observer::receive->$it")
                }
    }

    //通过调用concatMap关键字，可以有序弹出多个被观察者（发射器）
    fun concatMapDemo() {
        var TAG = "concatMap"
        Observable
                .just(1, 2, 3)
                .concatMap {
                    var data = it
                    var list = arrayListOf<Int>()
                    (0..2).mapTo(list) { 10 * it * data }
                    Observable.fromIterable(list).delay(500, TimeUnit.MILLISECONDS)
                }
                .subscribe { Log.e(TAG, "receive--->$it") }
    }

    //通过调用concatMap关键字，可以将发出数据出去重复
    fun distinctDemo() {
        var TAG = "distinct"
        Observable.just(1, 2, 3, 2, 4, 3)
                .distinct()
                .subscribe { Log.e(TAG, "receive--->$it") }
    }

    //通过调用filter关键字，可以将满足指定规则的数据过滤出来
    fun filterDemo() {
        var TAG = "filter"
        Observable.just(1, 2, 3, 4, 4, 3, 2, 1)
                .filter { it > 2 }
                .subscribe { Log.e(TAG, "receive--->$it") }
    }

    //通过调用buffer关键字，将数据按照指定的格式(count数组长度，skip数组赋值时，在数据中跳过的位置)，分割成数组。
    fun bufferDemo() {
        var TAG = "buffer"
        Observable.just(1, 2, 3, 4, 5, 6)
                .buffer(2, 1)
                .subscribe { Log.e(TAG, "receive--->$it"); }
    }

    //将数据与传入的初始数据(seed)进行处理,并得出最终结果
    fun reduceDemo() {
        var TAG = "reduce"
        Observable.just(1, 2, 3, 4).reduce(StringBuilder()) { seed, it ->
            seed.append("$it")
        }.subscribe { t1, t2 ->
            Log.e(TAG, "$t1---$t2")
        }
    }

    //将数据与传入的初始数据(seed)进行处理,并发出每一步的处理结果
    fun scanDemo() {
        var TAG = "scan"
        Observable.just(1, 2, 3, 4).scan { t1: Int, t2: Int -> t1 + t2 }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { Log.e(TAG, "$it") }
    }

    fun windowDemo() {
        var TAG = "window"
        Observable.just(1, 2, 3, 4, 5, 6, 7).window(3).subscribe {
            it.subscribe { Log.e(TAG, "$it") }
        }
    }

    //first 和 takefirst相同
    private fun getZipStringObservabl() = Observable.create<String> {
        var TAG = "zip"
        Log.e(TAG, "Observable:::send->aaa")
        it.onNext("aaa")
        Log.e(TAG, "Observable:::send->bbb")
        it.onNext("bbb")
        Log.e(TAG, "Observable:::send->ccc")
        it.onNext("ccc")
        Log.e(TAG, "Observable:::send->ddd")
        it.onNext("ddd")
    }

    private fun getZipIntObservabl() = Observable.create<Int> {
        var TAG = "zip"
        Log.e(TAG, "Observable:::send->111")
        it.onNext(111)
        Log.e(TAG, "Observable:::send->222")
        it.onNext(222)
        Log.e(TAG, "Observable:::send->333")
        it.onNext(333)
        Log.e(TAG, "Observable:::send->444")
        it.onNext(444)
    }
}