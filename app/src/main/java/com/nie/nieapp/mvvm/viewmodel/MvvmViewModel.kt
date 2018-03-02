package com.nie.nieapp.mvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nie.nieapp.mvvm.model.UserModel
import com.nie.nieapp.mvvm.room.User
import io.reactivex.*

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
class MvvmViewModel(val model: UserModel) : ViewModel() {
    fun loadAll() = model.loadAll()

    fun insertUser(user: User) =model.insertUser(user)

    fun delete(user: User) = model.delete(user)

}