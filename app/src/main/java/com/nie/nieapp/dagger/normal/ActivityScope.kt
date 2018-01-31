package com.nie.nieapp.dagger.normal

import javax.inject.Scope

/**
 * 说明：Activity局部单例
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
@Scope  //声明这是一个自定义@Scope注解
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
