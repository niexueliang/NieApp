package com.xly.netservice.net

import android.content.Context
import android.os.Handler
import android.app.ProgressDialog
import android.os.Message
import com.mwhtech.android.videocapture.slvideocapture.abc.util.no
import com.mwhtech.android.videocapture.slvideocapture.abc.util.yes
import com.nie.nieapp.R
import com.xly.nieapp.helper.inflate


/**
 * 说明：
 * Created by code_nil on 2017/12/22.
 */
class NetProgressHandler(private val context: Context, private val cancelable: Boolean, private val progressCallBack: () -> Unit) : Handler() {
    companion object {
        const val SHOW_PROGRESS_DIALOG = 1
        const val DISMISS_PROGRESS_DIALOG = 2
    }

    private var pd: ProgressDialog? = null
    //显示进度提示框
     fun showProgressDialog() {
        (pd == null).yes { pd = ProgressDialog(context) }
        pd?.run {
            setCancelable(cancelable)
            cancelable.yes {
                setOnCancelListener { progressCallBack() }//调用匿名函数，相当于回调通知dialog取消
            }
            isShowing.no {
                show()
                setContentView(context.inflate(R.layout.dialog_progress))
            }
        }
    }

    //关闭进度提示框
     fun dismissProgressDialog() {
        pd?.run { dismiss() }
        pd = null
    }

    //消息机制
    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        when (msg?.what) {

            SHOW_PROGRESS_DIALOG -> {
                showProgressDialog()
            }

            DISMISS_PROGRESS_DIALOG -> {
                dismissProgressDialog()
            }
        }
    }
}