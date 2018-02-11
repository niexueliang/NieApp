package com.nie.nieapp.dagger.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import com.nie.nieapp.reciver.WifiReceiver
import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import io.reactivex.subjects.BehaviorSubject

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
class BaseLifecycleObserver(private val context: Context, private val wifiReceiver: WifiReceiver) : LifecycleObserver, LifecycleProvider<ActivityEvent> {
    //rxlife管理
    private val lifecycleSubject = BehaviorSubject.create<ActivityEvent>()
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        lifecycleSubject.onNext(ActivityEvent.CREATE)
        WifiReceiver.register(context, wifiReceiver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        lifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        lifecycleSubject.onNext(ActivityEvent.START)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        lifecycleSubject.onNext(ActivityEvent.PAUSE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        lifecycleSubject.onNext(ActivityEvent.STOP)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY)
        WifiReceiver.unRegister(context, wifiReceiver)
    }


    //region rxlife继承的方法
    override fun lifecycle(): Observable<ActivityEvent> {
        return lifecycleSubject.hide()
    }

    override fun <T> bindUntilEvent(@NonNull event: ActivityEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }

    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject)
    }
    //endregion rxlife相关
}