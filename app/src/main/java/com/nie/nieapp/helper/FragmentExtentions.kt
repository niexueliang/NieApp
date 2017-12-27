package com.xly.nieapp.helper

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * 说明：fragment辅助类
 * Created by code_nil on 2017/12/8.
 */
fun FragmentActivity.findById(containerId: Int) = supportFragmentManager.findFragmentById(containerId)

fun FragmentActivity.findByTag(tag: String) = supportFragmentManager.findFragmentByTag(tag)

fun FragmentActivity.replace(@IdRes containerId: Int, fragment: Fragment) = supportFragmentManager.beginTransaction().replace(containerId, fragment).commit()

fun FragmentActivity.replaceTag(@IdRes containerId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag).commit()
}

fun FragmentActivity.replaceStack(@IdRes containerId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag).addToBackStack(null).commit()
}

fun FragmentActivity.remove(fragment: Fragment) = supportFragmentManager.beginTransaction().remove(fragment).commit()

fun FragmentActivity.back() = supportFragmentManager.popBackStack()

