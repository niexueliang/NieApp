package com.nie.nieapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.dfamatch.SearchFile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a="aaaa".hashCode()
        val b="aaab".hashCode()
        am_bt_data.setOnClickListener {
            SearchFile().searchFileLine()
        }
    }
}
