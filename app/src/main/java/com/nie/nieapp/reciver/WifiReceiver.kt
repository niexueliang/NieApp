package com.nie.nieapp.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.Parcelable

/**
 * 说明：0移动网络连接  1wifi连上  2移动网络断开  3wifi断开
 * Created by code_nil on 2017/9/20.
 */
class WifiReceiver constructor(private val action: (Int) -> Unit) : BroadcastReceiver() {

    companion object {
        fun register(context: Context, wifiReceiver: WifiReceiver) {
            val intentFilter = IntentFilter()
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
            intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            context.registerReceiver(wifiReceiver, intentFilter)
        }

        fun unRegister(context: Context, wifiReceiver: WifiReceiver) {
            context.unregisterReceiver(wifiReceiver)
        }
    }

    //每次应用启动都会触发监听
    override fun onReceive(context: Context?, intent: Intent?) {
        // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
        if (intent != null && ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
            //获取联网状态的NetworkInfo对象
            val info: Parcelable = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO)
            val networkInfo = info as NetworkInfo
            //如果当前的网络连接成功并且网络连接可用
            if (NetworkInfo.State.CONNECTED == networkInfo.state && networkInfo.isAvailable) {
                when (networkInfo.type) {
                    ConnectivityManager.TYPE_MOBILE -> {
                        //移动网络连上 使用action转发消息
                        action(0)
                    }
                    ConnectivityManager.TYPE_WIFI -> {
                        //WIFI网络连上  使用action转发消息
                        action(1)
                    }
                }
            } else {
                when (networkInfo.type) {
                //移动网络断开
                    ConnectivityManager.TYPE_MOBILE -> {
                        //"网络没有连接，请开启网络"
                        action(2)
                    }
                //WIFI网络断开
                    ConnectivityManager.TYPE_WIFI -> {
                        // 网络没有连接，请开启网络
                        action(3)
                    }
                }
            }
        }
    }
}
