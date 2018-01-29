package com.nie.nieapp.dagger.android

import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
@Subcomponent(modules = [AndroidInjectionModule::class])
interface FirstActivitySubcomponent : AndroidInjector<FirstActivity>{

}