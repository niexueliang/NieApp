package com.mwhtech.android.videocapture.slvideocapture.abc.util

/**
 * 说明：
 * Created by code_nil on 2017/12/15.
 */
fun Boolean.yes(action: () -> Unit): Boolean {
    if (this) {
        action()
    }
    return this
}

fun Boolean.no(action: () -> Unit): Boolean {
    if (!this) {
        action()
    }
    return this
}