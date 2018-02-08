package com.nie.nieapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.nie.nieapp.dfamatch.DfaMatch
import com.nie.nieapp.dfamatch.MatchFile
import com.nie.nieapp.dfamatch.SearchFile
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    var tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = "aaaa".hashCode()
        val b = "aaab".hashCode()
        val sf = SearchFile()
        val mf = MatchFile()
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
        }
    }
}
