package com.nie.nieapp.dagger.android

import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.normal.Student
import com.nie.nieapp.dagger.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
class TestActivity : BaseActivity() {
    @Inject
    lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        test.setOnClickListener {
            val odlStudent = intent.getSerializableExtra("student") as Student
            Log.e("TestActivity", student.name + ":::::" + odlStudent.name)
        }
    }
}