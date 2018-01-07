package com.nie.nieapp.dagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import com.nie.nieapp.dagger.module.DaggerModuleComponent
import com.nie.nieapp.dagger.module.ModuleNoParam
import com.nie.nieapp.dagger.module.ModuleParam
import kotlinx.android.synthetic.main.activity_dragger2.*
import javax.inject.Inject
import javax.inject.Named

class Dagger2Activity : AppCompatActivity() {

    @Inject lateinit var mNoParam: ModuleNoParam

    @Inject @Named("xx") lateinit var  mParam: ModuleParam
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragger2)

        DaggerModuleComponent.create().inject2(this)
        //注入
        da_test.setOnClickListener {

            mNoParam.loadData()
            mParam.loadData()
        }
    }
}
