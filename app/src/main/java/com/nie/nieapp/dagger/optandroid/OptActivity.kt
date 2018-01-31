package com.nie.nieapp.dagger.optandroid

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseActivity
import com.nie.nieapp.dagger.base.BaseApp
import com.nie.nieapp.dagger.normal.Student
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

/**
 * 说明：
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 */
class OptActivity : BaseActivity() {
    @Inject
    lateinit var name: String

    @Inject
    lateinit var app: BaseApp

    @Inject
    lateinit var sp: SharedPreferences

    @Inject
    @Named("aaa")
    lateinit var student: Student

    @Inject
    @Named("bbb")
    lateinit var appStudent: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        am_bt_data.setOnClickListener {
            val intent = Intent(this, Opt2Activity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
            Log.e("OptActivity", "app:::$app::::student$student:::::appStudent$appStudent")
        }

        fl_test.setOnClickListener {
            val trans = supportFragmentManager.beginTransaction()
            trans.add(R.id.fl_test, Opt3Fragment())
            trans.commit()
        }
    }
}