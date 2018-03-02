package com.nie.nieapp.dagger.case2

import dagger.Component


/**
 * 说明：
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
@Component(modules = [Case2Module::class])
//@Singleton
interface Case2Component {
    fun inject(activity: Case2Activity)
}