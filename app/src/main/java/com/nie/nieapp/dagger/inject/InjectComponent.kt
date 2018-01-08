package com.nie.nieapp.dagger.inject

import com.nie.nieapp.dagger.Dagger2Activity
import dagger.Component

/**
 * Created by Administrator on 2018/1/7.
 */
@Component
interface InjectComponent {
    fun inject(activity: Dagger2Activity)
}