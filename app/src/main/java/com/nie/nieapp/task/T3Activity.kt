package com.nie.nieapp.task

import android.app.ActivityManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import kotlinx.android.synthetic.main.activity_t3.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity

class T3Activity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t3)
        t3.setOnClickListener { startActivity<T4Activity>() }
    }
}
