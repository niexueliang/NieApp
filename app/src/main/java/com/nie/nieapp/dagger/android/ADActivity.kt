package com.nie.nieapp.dagger.android

import android.content.Intent
import android.os.Bundle
import com.nie.nieapp.R
import com.nie.nieapp.dagger.normal.Student
import com.nie.nieapp.dagger.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
class ADActivity : BaseActivity() {
    @Inject
    lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        am_bt_data.setOnClickListener {
            val intent=Intent(this,TestActivity::class.java)
            intent.putExtra("student",student)
            startActivity(intent)
        }
    }
}