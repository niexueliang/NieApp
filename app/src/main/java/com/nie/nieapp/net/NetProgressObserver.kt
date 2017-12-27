package com.xly.netservice.net

import android.content.Context
import com.mwhtech.android.videocapture.slvideocapture.abc.util.no
import com.xly.netservice.net.NetProgressHandler.Companion.DISMISS_PROGRESS_DIALOG
import com.xly.netservice.net.NetProgressHandler.Companion.SHOW_PROGRESS_DIALOG
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 说明：
 * Created by code_nil on 2017/12/22.
 */
class NetProgressObserver<T : Any?>(private val context: Context,private val dataCallBack: (T) -> Unit) : Observer<T> {
    private var d: Disposable? = null
    private val progressDialogHandler = NetProgressHandler(context, true) {
        d?.run {
            isDisposed.no { dispose() }
        }
    }

    override fun onError(e: Throwable) {
        dismissProgressDialog()
    }

    override fun onComplete() {
        dismissProgressDialog()
    }

    override fun onSubscribe(d: Disposable) {
        this.d = d
        showProgressDialog()
    }

    override fun onNext(t: T) {
        dataCallBack(t)//由于在complete调用所以不需要调用清除dialog
    }


    private fun showProgressDialog() {
        progressDialogHandler.obtainMessage(SHOW_PROGRESS_DIALOG).sendToTarget()
    }

    private fun dismissProgressDialog() {
        progressDialogHandler.obtainMessage(DISMISS_PROGRESS_DIALOG).sendToTarget()
    }
}