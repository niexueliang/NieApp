package com.nie.nieapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nie.nieapp.glide.GlideApp
import com.xly.netservice.net.ApiStrategy
import com.xly.netservice.net.NetProgressHandler
import com.xly.netservice.net.NetProgressObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pbh = NetProgressHandler(this@MainActivity, true, {})
        am_bt_data.setOnClickListener {
            ApiStrategy
                    .getApiService
                    .getTopMovie(0, 10)
                    .doOnNext {
                        it.addProperty("nie","jajajajajaja")
                    }
                    .doOnError { Log.e(tag, "error-->$it") }
                    .subscribeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(NetProgressObserver(this) {
                        Log.e(tag, "error-->$it")
                    })

        }
    }
}
