package com.nie.nieapp.dagger.android

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module(subcomponents = [TestActivitySubComponent::class])
abstract class TestActivityModule {
    @Binds  //绑定
    @IntoMap
    @ActivityKey(TestActivity::class) //指定activity
    abstract fun bindTestActivityInjectorFactory(builder: TestActivitySubComponent.Builder)
            : AndroidInjector.Factory<out Activity>
}