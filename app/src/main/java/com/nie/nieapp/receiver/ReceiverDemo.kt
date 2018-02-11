package com.nie.nieapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.nie.nieapp.reciver.WifiReceiver

/**
 * 说明：
 * Created by code_nil on 2018/2/8.
 * 君子自强不息
 */
//LocalBroadcastReceiver
object ReceiverDemo {
    private val wifiReceiver =xxx()

    //local
    fun localRegist(context: Context) {
        val intentFilter = IntentFilter("111")
        LocalBroadcastManager.getInstance(context).registerReceiver(wifiReceiver, intentFilter)
        LocalBroadcastManager.getInstance(context).sendBroadcast(Intent("111"))
    }


    fun localUnRegist(context: Context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(wifiReceiver)
    }

}

class xxx : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "111") {
            Log.e("WifiReceiver", "发射广播")
        }
    }

}
