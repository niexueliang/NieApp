package com.nie.nieapp.dagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import javax.inject.Inject

class Dragger2Activity : AppCompatActivity() {
    @Inject lateinit var mainPressenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragger2)
//        println(B().getData())
        DaggerMainComponent.builder().mainModule(MainModule(this)).build().inject(this)
        mainPressenter.loadData()
    }
}
