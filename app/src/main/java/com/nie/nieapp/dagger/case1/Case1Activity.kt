package com.nie.nieapp.dagger.case1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.Car
import kotlinx.android.synthetic.main.activity_dcase1.*
import javax.inject.Inject

class Case1Activity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerCase1Component.create().inject(this)
        setContentView(R.layout.activity_dcase1)
        case1.setOnClickListener {
            Log.e("DCase1Activity","name:::${car.name}")
        }
    }
}
