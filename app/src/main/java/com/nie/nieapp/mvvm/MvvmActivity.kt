package com.nie.nieapp.mvvm

import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.nie.nieapp.R
import com.nie.nieapp.dagger.base.BaseActivity
import com.nie.nieapp.mvvm.room.User
import com.nie.nieapp.mvvm.viewmodel.MvvmViewModel
import com.nie.nieapp.net.ApiService
import com.nie.nieapp.net.UploadFileRequestBody
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mvvm.*
import okhttp3.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import retrofit2.Call
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class MvvmActivity : BaseActivity(), AnkoLogger {

    @Inject
    lateinit var viewModel: MvvmViewModel

    @Inject
    lateinit var service: ApiService

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
//            service.getTopMovie(0,10).subscribeOn(Schedulers.io()).subscribe {
//                error { "data::::$it" }
//            }
            val file1 = File("${Environment.getExternalStorageDirectory().absolutePath}/test1.txt")
            val file2 = File("${Environment.getExternalStorageDirectory().absolutePath}/test2.txt")
            val file3 = File("${Environment.getExternalStorageDirectory().absolutePath}/test3.txt")
            val body1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1)
            val body2 = RequestBody.create(MediaType.parse("multipart/form-data"), file2)
            val body3 = RequestBody.create(MediaType.parse("multipart/form-data"), file3)
            val builder = MultipartBody
                    .Builder()
                    .setType(MultipartBody.FORM)//表单类型
                    .addFormDataPart("1", file1.name, body1)
                    .addFormDataPart("2", file2.name, body2)
                    .addFormDataPart("3", file3.name, body3)
            val parts = builder.build().parts()
            service.uploadFile(parts).enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                    Log.e("xxx", "xxxxx")
                }

                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    Log.e("xxx", "${t?.message}")
                }

            })
        }

        add.setOnClickListener {
            viewModel
                    .insertUser(User("nie", 17))
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        Log.e("result", "insrt success")
                    }, {
                        Log.e("result", it.message)
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
