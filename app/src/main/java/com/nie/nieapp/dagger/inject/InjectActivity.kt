package com.nie.nieapp.dagger.inject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nie.nieapp.R
import com.nie.nieapp.application.App
import kotlinx.android.synthetic.main.activity_inject.*
import javax.inject.Inject

class InjectActivity : AppCompatActivity() {
    @Inject lateinit var iNoParam: InjectNoParam
    @Inject lateinit var iParam: InjectParam
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject)
        DaggerInjectComponent.create().inject(this)
        ia_test.setOnClickListener {
            iNoParam.loadData()
            iParam.loadData()
        }
    }
}
