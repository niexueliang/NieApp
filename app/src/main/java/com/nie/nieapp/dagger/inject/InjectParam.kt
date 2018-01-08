package com.nie.nieapp.dagger.inject

import android.util.Log
import javax.inject.Inject

/**
 * val name: String
 * Created by Administrator on 2018/1/7.
 */
class InjectParam @Inject constructor(val bean:InjectBean) {
    fun loadData() {
        Log.e("ttttt", "Inject-->有参注入：：：${bean.logName}}")
    }
}