package com.nie.nieapp.dagger.module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import kotlinx.android.synthetic.main.activity_dragger2.*
import javax.inject.Inject
import javax.inject.Named

class Dagger2Activity : AppCompatActivity() {


    @Inject
    @field:Named("nxl") lateinit var mNie: ModuleParam

    @Inject
    @field:Named("xx") lateinit var mXx: ModuleParam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragger2)

//        DaggerModuleComponent.create().inject2(this)
        //注入
        da_test.setOnClickListener {

            mNie.loadData()
            mXx.loadData()
        }
    }
}
