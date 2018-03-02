package com.nie.nieapp.dagger.case3

import dagger.Component
import dagger.Subcomponent

/**
 * 说明：
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */
@Subcomponent
interface SonComponent {
    fun inject(son: Son)

    // SubComponent 必须显式地声明 Subcomponent.Builder，父Component 需要用 Builder 来创建 SubComponent
    @Subcomponent.Builder
    interface Builder {
        fun build(): SonComponent
    }
}