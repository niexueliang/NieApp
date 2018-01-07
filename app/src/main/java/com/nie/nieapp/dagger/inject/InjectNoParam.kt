package com.nie.nieapp.dagger.inject

import android.util.Log
import javax.inject.Inject

/**
 * val name: String
 * Created by Administrator on 2018/1/7.
 */
class InjectNoParam @Inject constructor() {
    fun loadData() {
        Log.e("ttttt", "Inject-->无参数注入")
    }
}