package com.nie.nieapp.dagger.normal

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.app.ComponentHolder
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
class NormalActivity : AppCompatActivity() {
    @Inject
    lateinit var student: Student

    @Inject
    lateinit var student2: Student
    @Inject
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerNormalComponent
                .builder()
                .appComponent(ComponentHolder.myAppComponent)
                .normalModule(NormalModule(this))
                .build()
                .inject(this)
        am_bt_data.setOnClickListener {
            init()
        }
    }

    private fun init() {
        Log.e("NormalActivity", "${student === student2}")
        val result = sp.edit().putString("activity", "NormalActivity").commit()
        Log.e("result", "$result")
    }
}