package com.nie.nieapp.dagger.da

import android.os.Bundle
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dagger_common.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import javax.inject.Inject

/**
 * 说明：继承BaseActivity，采用通用的方式注入
 * Created by code_nil on 2018/3/2.
 * 君子自强不息
 */
class DaggerCommonActivity : BaseActivity(), AnkoLogger {
    @Inject
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_common)
        dagger_common.setOnClickListener {
            error { "注入的数据::::$name" }
        }
    }

    override fun responseWifiReceiver(code: Int) {
        error { "code::::$code" }
    }

}