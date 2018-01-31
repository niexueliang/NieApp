package com.nie.nieapp.dagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * 说明：通用的activity注入类
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
open class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)//dagger2 androd扩展库
        super.onCreate(savedInstanceState)
    }
}