package com.nie.nieapp.dagger.inject

import android.util.Log
import javax.inject.Inject

/**
 * Created by Administrator on 2018/1/7.
 */
class InjectBean @Inject constructor(){
     val logName: String = "Inject方式注入，最后一个注入类必定没有参数"
}