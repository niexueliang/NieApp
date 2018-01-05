package com.xly.nieapp.helper

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 说明：
 * Created by code_nil on 2017/12/8.
 */
 fun Context.inflate(@LayoutRes layoutId: Int, parent: ViewGroup? = null, attach: Boolean = false) = LayoutInflater.from(this).inflate(layoutId, parent, attach)

fun ViewGroup.inflate(@LayoutRes id: Int, attach: Boolean = false): View = this.context.inflate(id, this, attach)

fun Context.checkNetworkStatus(): Boolean {
    val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    var networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    val isWifiConn = networkInfo.isConnected

    networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    val isMobileConn = networkInfo.isConnected

    return isMobileConn || isWifiConn
}