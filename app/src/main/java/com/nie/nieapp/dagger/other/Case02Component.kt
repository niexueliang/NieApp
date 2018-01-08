package com.nie.nieapp.dagger.other


import dagger.Component

/**
 * @author JY
 * @Time 2017/12/12 16:05
 */

@Component(modules = arrayOf(Case02Module::class))
interface Case02Component {
    fun inject(activity: Case02Activity)
}
