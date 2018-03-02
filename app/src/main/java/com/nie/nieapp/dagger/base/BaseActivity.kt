package com.nie.nieapp.dagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nie.nieapp.reciver.WifiReceiver
import dagger.android.AndroidInjection

/**
 * 说明：通用的activity注入类
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
abstract class BaseActivity : AppCompatActivity() {
    lateinit var lifecycleObserver: BaseLifecycleObserver

    private val wifiReceiver = WifiReceiver {
        responseWifiReceiver(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //dagger2 androd扩展库
        AndroidInjection.inject(this)
        //创建lifecycle监听器
        lifecycleObserver = BaseLifecycleObserver(this, wifiReceiver)
        //关联lifecycle
        lifecycle.addObserver(lifecycleObserver)
        super.onCreate(savedInstanceState)
    }


    abstract fun responseWifiReceiver(code: Int)

}