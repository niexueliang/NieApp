package com.nie.nieapp.dfamatch

import android.os.Environment
import android.util.Log
import android.util.Xml
import jxl.Cell
import jxl.CellType
import jxl.Workbook
import org.textmining.text.extraction.WordExtractor
import org.xmlpull.v1.XmlPullParser
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.util.zip.ZipFile

/**
 * 说明：
 * Created by code_nil on 2018/2/2.
 * 君子自强不息
 */
class MatchFile {
    private val keyArray = arrayOf("法轮功", "血腥玛丽", "哈利", "肢解", "枪杀", "真主阿拉", "真主", "血腥", "av", "av女友", "国军", "圣战", "阿拉", "买买提", "专家报告", "农业林业水利和气象支出")

    /**
     * 检索sd卡下所有的文件
     */
    fun searchFileLine(file: File = Environment.getExternalStorageDirectory()) {
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        /**
         * 仿造file的readline语法糖，解决开启两次的问题
         */
        file.walk().maxDepth(Int.MAX_VALUE).filter { it.isFile && (it.extension == "txt") }.forEach {
            val headBuffer = ByteArray(3)
            val inputStream = it.inputStream()
            val readCount = inputStream.read(headBuffer)
            var charset = "utf-8"
            if (readCount == 3) {
                charset = getTextCharset(headBuffer)
            }
            inputStream.close()
            it.forEachLine(Charset.forName(charset)) {
                DfaMatch.searchSensitive(it, keyMap)
            }
        }
    }

    /**
     * 获取text文本的编码
     */
    private fun getTextCharset(head: ByteArray): String {
        var code = "gb2312"
        if (head[0].toInt() == -1 && head[1].toInt() == -2)
            code = "utf-16"
        if (head[0].toInt() == -2 && head[1].toInt() == -1)
            code = "unicode"
        if (head[0].toInt() == -17 && head[1].toInt() == -69 && head[2].toInt() == -65)
            code = "utf-8"
        return code
    }

    /**
     * 将gbk字符串转化为utf-8数组
     */
    private fun getUTF8BytesFromGBKString(gbkStr: String): ByteArray {
        val n = gbkStr.length
        val utfBytes = ByteArray(3 * n)
        var k = 0
        for (i in 0 until n) {
            val m = gbkStr[i].toInt()
            if (m in 0..127) {
                utfBytes[k++] = m.toByte()
                continue
            }
            utfBytes[k++] = (0xe0 or (m shr 12)).toByte()
            utfBytes[k++] = (0x80 or (m shr 6 and 0x3f)).toByte()
            utfBytes[k++] = (0x80 or (m and 0x3f)).toByte()
        }
        if (k < utfBytes.size) {
            val tmp = ByteArray(k)
            System.arraycopy(utfBytes, 0, tmp, 0, k)
            return tmp
        }
        return utfBytes
    }

    fun searchWordFile(file: File= Environment.getExternalStorageDirectory()) {
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        file.walk().maxDepth(Int.MAX_VALUE).filter {it.isFile && it.extension == "doc" }.forEach {
            try {
                val inputStream = FileInputStream(it)
                val we = WordExtractor()
                val text = we.extractText(inputStream)
                Log.e("WordFile","name${it.absolutePath}")
                DfaMatch.searchSensitive(text, keyMap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchWordxFile(file: File= Environment.getExternalStorageDirectory()) {
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        file.walk().maxDepth(Int.MAX_VALUE).filter { it.extension == "docx" }.forEach {
            try {
                val zipFile = ZipFile(it)
                val xmlEntity = zipFile.getEntry("word/document.xml")
                val xmlIs = zipFile.getInputStream(xmlEntity)
                val xmlParser = Xml.newPullParser()
                xmlParser.setInput(xmlIs, "utf-8")
                var eventType = xmlParser.eventType
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    when (eventType) {
                        XmlPullParser.START_TAG -> {
                            val tag = xmlParser.name
                            if (tag.equals("t", true)) {
                                val txt = xmlParser.nextText()
                                DfaMatch.searchSensitive(txt, keyMap)
                            }
                        }
                    }
                    eventType = xmlParser.next()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchXlsFile(file: File= Environment.getExternalStorageDirectory()) {
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        file.walk().maxDepth(Int.MAX_VALUE).filter { it.isFile && it.extension == "xls" }.forEach {
            try {
                val workBook = Workbook.getWorkbook(it)
                workBook.sheets?.forEach {
                    val columCount = it.columns
                    val rowCount = it.rows
                    for (i in 0 until columCount) {
                        (0 until rowCount)
                                .map { j -> it.getCell(i, j).contents }
                                .forEach { DfaMatch.searchSensitive(it, keyMap) }
                    }
                }
                workBook.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchXlsxFile() {
        val file = Environment.getExternalStorageDirectory()
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        file.walk().maxDepth(Int.MAX_VALUE).filter { it.isFile && it.extension == "xlsx" }.forEach {
            val zipFile = ZipFile(it)
            //解析sharedStrings文件
            try {
                val xmlEntity = zipFile.getEntry("xl/sharedStrings.xml")
                val xmlIs = zipFile.getInputStream(xmlEntity)
                val xmlParser = Xml.newPullParser()
                xmlParser.setInput(xmlIs, "utf-8")
                var eventType = xmlParser.eventType
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    when (eventType) {
                        XmlPullParser.START_TAG -> {
                            val tag = xmlParser.name
                            if (tag.equals("t", true)) {
                                val txt = xmlParser.nextText()
                                DfaMatch.searchSensitive(txt, keyMap)
                            }
                        }
                    }
                    eventType = xmlParser.next()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}