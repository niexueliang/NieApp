package com.nie.nieapp.dagger.case2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nie.nieapp.R
import com.nie.nieapp.dagger.Car
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_case02.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import javax.inject.Inject
import javax.inject.Provider

/**
 * 说明：
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
class Case2Activity : AppCompatActivity(), AnkoLogger {
    @Inject
    lateinit var c1: Car
    //懒加载
    @Inject
    lateinit var c2: Lazy<Car>
    //生成不同实例
    @Inject
    lateinit var c3: Provider<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerCase2Component.builder().case2Module(Case2Module(this)).build().inject(this)
        setContentView(R.layout.activity_case02)
        case2.setOnClickListener {
            error { "name:::${c2.get()}" }
        }
    }
}