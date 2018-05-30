package com.nie.nieapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.nie.nieapp.designmode.AbstractFactory.FamilyFactory
import com.nie.nieapp.designmode.AbstractFactory.SingleFactory
import com.nie.nieapp.designmode.factorymethod.Factory
import com.nie.nieapp.dfamatch.MatchFile
import com.nie.nieapp.dfamatch.SearchFile
import com.nie.nieapp.ftp.FTP
import com.nie.nieapp.receiver.ReceiverCycle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import java.io.File
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), AnkoLogger {
    var tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(ReceiverCycle(this))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val a = "aaaa".hashCode()
//        val b = "aaab".hashCode()
//        val sf = SearchFile()
//        val mf = MatchFile()
        am_bt_data.setOnClickListener {
            //            Log.e(tag, "APK文件检索")
//            val apkList = sf.searchFileForExtension(SearchFile.apkExtensions)
//            Log.e(tag, "$apkList")
//            Log.e(tag, "video文件检索")
//            val videoList = sf.searchFileForExtension(SearchFile.videoExtensions)
//            Log.e(tag, "$videoList")
//            Log.e(tag, "视频文件检索")
//            val videoList = sf.searchVfForHead()
//            Log.e(tag, "$videoList")
//
//            Log.e(tag, "文本文件检索")
//            val txtList = mf.searchFileLine()
//            Log.e(tag, "$txtList")
//
//
//            Log.e(tag, "docx文件检索")
//            val docxList = mf.searchWordxFile()
//            Log.e(tag, "$docxList")
//
//
//            Log.e(tag, "xlsx文件检索")
//            val xlsxList = mf.searchXlsxFile()
//            Log.e(tag, "$xlsxList")

//            Log.e(tag, "doc文件检索")
//            val docList = mf.searchWordFile()
//            Log.e(tag, "$docList")

//            Log.e(tag, "xls文件检索")
//            val xlsList = mf.searchXlsFile()
//            Log.e(tag, "$xlsList")
//            val sFactory = SingleFactory()
//
//            val sPizza = sFactory.createPizza()
//            sPizza.create()
//            val sHamburger = sFactory.createHamburger()
//            sHamburger.create()
//
//            val mFactory = FamilyFactory()
//            val mPizza = mFactory.createPizza()
//            mPizza.create()
//            val mHamburger = mFactory.createHamburger()
//            mHamburger.create()
            thread {
                val ftp = FTP()
                val operate = ftp.beforeOperate("video")
                if (operate) {
                    val path = Environment.getExternalStorageDirectory().absolutePath + File.separator + "xx.avi"
                    val file = File(path)
                    error { "filesize::::${file.length()}" }
                    error { "starttime::::${System.currentTimeMillis()}" }
                    ftp.uploadingSingle(file)
                    error { "endtime::::${System.currentTimeMillis()}" }
                }
                ftp.afterOperate()
            }
        }
    }
}
