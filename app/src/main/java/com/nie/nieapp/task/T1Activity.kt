package com.nie.nieapp.task

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import kotlinx.android.synthetic.main.activity_t1.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity


class T1Activity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t1)
        t1.setOnClickListener { startActivity<T2Activity>() }
    }
}
