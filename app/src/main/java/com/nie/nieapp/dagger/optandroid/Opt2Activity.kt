package com.nie.nieapp.dagger.optandroid

import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseActivity
import com.nie.nieapp.dagger.base.App
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
class Opt2Activity : BaseActivity() {
    @Inject
    lateinit var name: String

    @Inject
    lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        test.setOnClickListener {
            //            val oldName = intent.getStringExtra("name")
//            Log.e("TestActivity", name + ":::::" + oldName)
            Log.e("OptActivity", "app:::$app")
        }
    }
}