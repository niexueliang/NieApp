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
        am_bt_data.setOnClickListener {
            //            val result=sf.searchVideFile(File(Environment.getExternalStorageDirectory().absolutePath+File.separator+"video"))
//            Log.e(tag,"$result")
            //File(Environment.getExternalStorageDirectory().absolutePath+File.separator+"xx.txt")
            MatchFile().searchFileLine(File(Environment.getExternalStorageDirectory().absolutePath + File.separator + "xx.txt"))
        }
    }
}
