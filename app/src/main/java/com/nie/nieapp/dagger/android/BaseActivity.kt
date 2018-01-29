package com.nie.nieapp.dagger.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)//android dagger2
    }
}