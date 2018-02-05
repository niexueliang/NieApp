package com.nie.nieapp.net

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.Parcelable

/**
 * 说明：
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
object NetWorkUtil {
    /**
     * 0未连接 1移动网络连上 2WIFI网络连上
     */
    fun networkState(context: Context): Int {
        var connectType = 0
        //获取联网状态的NetworkInfo对象
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.allNetworkInfo?.let {
            it.filter { it.state === NetworkInfo.State.CONNECTED }
                    .map {
                        //判定网络连接的方式
                        when (it.type) {
                        //移动网络连上 使用action转发消息
                            ConnectivityManager.TYPE_MOBILE -> connectType = 1
                        //WIFI网络连上  使用action转发消息
                            ConnectivityManager.TYPE_WIFI -> connectType = 2
                        }
                    }
        }
        return connectType
    }
}