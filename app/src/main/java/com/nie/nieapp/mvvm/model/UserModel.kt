package com.nie.nieapp.mvvm.model

import com.nie.nieapp.mvvm.room.User
import com.nie.nieapp.mvvm.room.UserDao
import com.nie.nieapp.net.ApiService
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
class UserModel(val dao: UserDao,val apiService: ApiService) {
    fun loadAll() = dao.load()

    fun insertUser(user: User) = Flowable
            .create(FlowableOnSubscribe<Long> {
                it.onNext(dao.insert(user))
            }, BackpressureStrategy.BUFFER)

    fun delete(user: User) = Flowable
            .create(FlowableOnSubscribe<Int> {
                it.onNext(dao.delete(user))
            }, BackpressureStrategy.BUFFER)

}