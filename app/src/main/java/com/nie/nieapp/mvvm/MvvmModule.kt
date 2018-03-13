package com.nie.nieapp.mvvm

import android.arch.lifecycle.ViewModelProviders
import com.nie.nieapp.mvvm.common.ViewModelFactory
import com.nie.nieapp.mvvm.model.UserModel
import com.nie.nieapp.mvvm.room.UserDao
import com.nie.nieapp.mvvm.viewmodel.MvvmViewModel
import com.nie.nieapp.net.ApiService
import dagger.Module
import dagger.Provides

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
@Module
class MvvmModule {
    @Provides
    fun provideUserModel(dao: UserDao,apiService: ApiService): UserModel {
        return UserModel(dao,apiService)
    }

    @Provides
    fun provideUserViewModel(activity: MvvmActivity, model: UserModel): MvvmViewModel {
        val factory = ViewModelFactory(model)
        return ViewModelProviders.of(activity, factory).get(MvvmViewModel::class.java)
    }

}