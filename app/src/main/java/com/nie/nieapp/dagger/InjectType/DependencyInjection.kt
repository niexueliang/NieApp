package com.nie.nieapp.dagger.InjectType

import android.util.Log
import com.nie.nieapp.mvvm.room.User

/**
 * 说明：依赖注入
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */


//构造注入
class ConstructorInject(user: User)

//set方式注入
class SetInject {
    var user: User? = null
        set(value) {
            Log.e("SetInject", "Kotlin直接默认实现了Set属性")
            field = value
        }
}

//接口注入
interface UserInterface {
    fun injector(user: User)
}

class InterfaceInject : UserInterface {
    var user: User? = null
    override fun injector(user: User) {
        Log.e("InterfaceInject","调用接口实现注入")
        this.user = user
    }
    fun println(){
        Log.e("InterfaceInject","user::::$user")
    }
}

//注解方式实现注入  Dagger2

