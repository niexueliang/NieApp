package com.nie.nieapp.application

import dagger.Component

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
}