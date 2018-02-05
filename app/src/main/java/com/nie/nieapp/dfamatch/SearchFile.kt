package com.nie.nieapp.dfamatch
import android.os.Environment
import java.nio.charset.Charset

/**
 * 说明：
 * Created by code_nil on 2018/2/2.
 * 君子自强不息
 */
class SearchFile {
    private val keyArray = arrayOf("法轮功", "血腥玛丽", "哈利", "肢解", "枪杀", "真主阿拉", "真主", "血腥", "av", "av女友", "国军", "圣战", "阿拉")

    /**
     * 检索sd卡下所有的文件
     */
    fun searchFileLine() {
        val file = Environment.getExternalStorageDirectory()
        val keyMap = DfaMatch.createSensitiveMap(keyArray)
        file.walk().maxDepth(Int.MAX_VALUE).filter { it.isFile && (it.extension == "txt") }.forEach {
            val headBuffer = ByteArray(3)
            val inputStream = it.inputStream()
            val readCount = inputStream.read(headBuffer)
            var code = "utf-8"
            if (readCount == 3) {
                code = getTextCharset(headBuffer)
            }
            inputStream.close()
            it.forEachLine(Charset.forName(code)) {
                DfaMatch.searchSensitive(it, keyMap)
            }
        }
    }

    /**
     * 获取text文本的编码
     */
    fun getTextCharset(head: ByteArray): String {
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
    fun getUTF8BytesFromGBKString(gbkStr: String): ByteArray {
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
}