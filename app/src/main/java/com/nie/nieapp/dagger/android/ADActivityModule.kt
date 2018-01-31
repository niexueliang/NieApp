package com.nie.nieapp.dagger.android

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import android.app.Activity
import com.nie.nieapp.MainActivity


/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Module(subcomponents = [ADActivitySubComponent::class])
abstract class ADActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ADActivity::class)
    abstract fun bindADActivityInjectorFactory(builder: ADActivitySubComponent.Builder):
            AndroidInjector.Factory<out Activity>
}