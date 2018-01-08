package com.nie.nieapp.dagger.inject

import dagger.Component

/**
 * Created by Administrator on 2018/1/7.
 */
@Component
interface InjectComponent {
    fun inject(activity: InjectActivity)
}