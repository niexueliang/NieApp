package com.nie.nieapp.task

import android.app.ActivityManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class T4Activity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t4)
    }
}
