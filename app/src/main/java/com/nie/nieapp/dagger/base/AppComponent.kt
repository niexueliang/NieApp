package com.nie.nieapp.dagger.base

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
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,//app的module，可以得到application提供的实例
    ApiModule::class,//api的module,得到网络实例
    BaseModule::class])
interface AppComponent {
    fun inject(application: App)
}