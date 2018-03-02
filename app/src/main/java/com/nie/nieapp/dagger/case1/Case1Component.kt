package com.nie.nieapp.dagger.case1

import dagger.Component

/**
 * 说明：
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
@Component
interface Case1Component {
    fun inject(activity: Case1Activity)
}