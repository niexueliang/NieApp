package com.nie.nieapp.dagger.module

import android.util.Log
import javax.inject.Inject

/**
 * val name: String
 * Created by Administrator on 2018/1/7.
 */
class ModuleParam  constructor(val bean: String) {
    fun loadData() {
        Log.e("ttttt", "Module-->有参注入：：：$bean}")
    }
}