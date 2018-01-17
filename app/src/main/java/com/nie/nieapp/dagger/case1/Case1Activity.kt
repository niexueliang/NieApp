package com.nie.nieapp.dagger.case1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import kotlinx.android.synthetic.main.activity_case1.*
import javax.inject.Inject

class Case1Activity : AppCompatActivity() {
    @Inject lateinit var orangeBean: OrangeBean
    @Inject lateinit var appleBean: AppleBean
    @Inject lateinit var fruits: Fruits
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFruitComponent.builder().orangeModule(OrangeModule(OrangeBean("青橘",8.0f))).build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case1)
        ac1_test.setOnClickListener {
            Log.e("Case1Activity", orangeBean.toString())
            Log.e("Case1Activity", appleBean.toString())
            Log.e("Case1Activity", fruits.toString())
        }
    }
}
