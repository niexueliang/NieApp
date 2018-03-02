package com.nie.nieapp.dagger.di.component

import com.nie.nieapp.dagger.base.BaseApp
import com.nie.nieapp.dagger.di.module.AppModule
import com.nie.nieapp.dagger.di.module.AllModule
import com.nie.nieapp.mvvm.room.DaoModule
import com.nie.nieapp.net.ApiModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Component(modules = [
    AndroidInjectionModule::class,//基础组件的注解(Activity、Fragment、BroadcastReceive、Service)
    AndroidSupportInjectionModule::class,//v4包的Fragment注解
    AppModule::class,//app的module，可以得到application提供的实例
    ApiModule::class,//api的module,得到网络实例
    DaoModule::class,//数据库的module
    AllModule::class])
interface AppComponent {
    fun inject(application: BaseApp)
}