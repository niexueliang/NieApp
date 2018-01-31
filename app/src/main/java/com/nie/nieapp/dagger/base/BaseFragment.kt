package com.nie.nieapp.dagger.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * 说明：通用的Fragment注入类
 * Created by code_nil on 2018/1/31.
 * 君子自强不息
 */
open class BaseFragment : Fragment() {
    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}