package com.nie.nieapp.dagger.case3

import dagger.Component

/**
 * 说明：依赖共享
 * Created by code_nil on 2018/2/28.
 * 君子自强不息
 */
@Component(dependencies = [ManComponent::class])
interface FriendComponent {
    fun inject(friend: Friend)
}