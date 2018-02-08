package com.nie.nieapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager

/**
 * 说明：
 * Created by code_nil on 2018/2/8.
 * 君子自强不息
 */
//LocalBroadcastReceiver
class ReceiverDemo {
    //local
    fun localSend(context: Context) {
        val rr = RdReceiver()
        LocalBroadcastManager.getInstance(context).registerReceiver(rr, IntentFilter("LocalBroadcast"))
        LocalBroadcastManager.getInstance(context).sendBroadcast(Intent("LocalBroadcast"))
        LocalBroadcastManager.getInstance(context).unregisterReceiver(rr)
    }
}

class RdReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
    }
}