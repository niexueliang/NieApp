package com.nie.nieapp.dagger.other

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


import com.nie.nieapp.R

import javax.inject.Inject
import javax.inject.Named

class Case02Activity : AppCompatActivity() {

//    @Inject
//    @Named("green")
//    lateinit var cp1: ColorPicker

    //    @Named("blue")
    @Inject
    @field:Named("blue") lateinit var cp2: ColorPicker

    annotation class Ann


    var line1: TextView? = null
    var line2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case02)
        line1 = findViewById<View>(R.id.line1) as TextView
        line2 = findViewById<View>(R.id.line2) as TextView
        DaggerCase02Component.builder().build().inject(this)
    }

    fun test(v: View) {
        //        line1.setTextColor(cp.pick());
        //        line2.setTextColor(cp.pick());
//        line1!!.setTextColor(cp1!!.pick())
        line2!!.setTextColor(cp2!!.pick())
    }
}

