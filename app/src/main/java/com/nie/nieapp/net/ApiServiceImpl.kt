package com.xly.netservice.net

import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 说明：
 * Created by code_nil on 2017/12/21.
 */
object ApiServiceImpl {

    private fun <T : Any?> baseSubscribe(observable: Observable<T>, observer: Observer<T>) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun getTopMove(start: Int, end: Int, observer: Observer<JsonObject>) = baseSubscribe(ApiStrategy.getApiService.getTopMovie(start, end), observer)

}