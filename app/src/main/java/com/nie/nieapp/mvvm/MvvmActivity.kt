package com.nie.nieapp.mvvm

import android.os.Bundle
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseActivity
import com.nie.nieapp.mvvm.room.User
import com.nie.nieapp.mvvm.viewmodel.MvvmViewModel
import com.xly.netservice.net.ApiService
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mvvm.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import javax.inject.Inject
import kotlin.concurrent.thread

class MvvmActivity : BaseActivity(),AnkoLogger {

    @Inject
    lateinit var viewModel: MvvmViewModel

    @Inject lateinit var service: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        show.setOnClickListener {
//            viewModel
//                    .loadAll()
//                    .subscribeOn(Schedulers.io())
//                    .subscribe({
//                        Log.e("result", it.toString())
//                    }, {
//                        Log.e("result",  it.message)
//                    })
            service.getTopMovie(0,10).subscribeOn(Schedulers.io()).subscribe {
                error { "data::::$it" }
            }
        }

        add.setOnClickListener {
            viewModel
                    .insertUser(User("nie", 17))
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        Log.e("result", "insrt success")
                    }, {
                        Log.e("result",  it.message)
                    })
        }

        delete.setOnClickListener {
            viewModel
                    .delete(User("nie", 17))
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        Log.e("result", "delete success")
                    }, {
                        Log.e("result", it.message)
                    })
        }
    }

    override fun responseWifiReceiver(code: Int) {
    }
}
