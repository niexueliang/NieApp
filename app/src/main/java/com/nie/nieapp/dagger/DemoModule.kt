package com.nie.nieapp.dagger

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 说明：
 * Created by code_nil on 2018/1/5.
 * 君子自强不息
 */
/**
 * 方式2 使用@Module
 */
class C {
    fun getData() = "kotlin中使用@Moudle的方式，获取到了C 的实例化对象"
}

@Module//使用module
class D {
    @Provides//产生C的实例
    fun provideC() = C()
}

@Singleton
@Component(modules = [D::class])
interface CDComponent {//关联module和module
    fun inject(e: App)
}

class App {
    @Inject lateinit var c: C
    init {
        DaggerCDComponent.create().inject(this)
    }
    fun getData() = c.getData()
}
