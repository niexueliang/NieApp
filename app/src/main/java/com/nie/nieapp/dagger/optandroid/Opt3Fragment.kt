package com.nie.nieapp.dagger.optandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseFragment
import com.nie.nieapp.dagger.normal.Student
import javax.inject.Inject

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
class Opt3Fragment : BaseFragment() {
    @Inject
    lateinit var student: Student


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.activity_test, container, false)
        view?.findViewById<Button>(R.id.test)?.setOnClickListener {
            Log.e("Opt3Fragment", student.name)
        }
        return view
    }
}