package com.nie.nieapp.dfamatch

import android.os.Environment
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

/**
 * 说明：
 * Created by code_nil on 2018/2/5.
 * 君子自强不息
 */
class SearchFile {

    //搜搜apk文件
    fun searchApkFile(file: File = Environment.getExternalStorageDirectory()): ArrayList<File> {
        return file
                .walk()
                .maxDepth(Int.MAX_VALUE)
                .filter { it.isFile && it.extension == "apk" }
                .mapTo(ArrayList()) { it }
    }

    //搜索视频文件
    fun searchVfForExtension(file: File = Environment.getExternalStorageDirectory()): ArrayList<File> {
        return file
                .walk()
                .maxDepth(Int.MAX_VALUE)
                .filter {
                    it.isFile && ((it.extension == "mp4")
                            || (it.extension == "avi")
                            || (it.extension == "mpeg")
                            || (it.extension == "mov")
                            || (it.extension == "asf")
                            || (it.extension == "wmf")
                            || (it.extension == "rm")
                            || (it.extension == "rmvb")
                            || (it.extension == "flv")
                            || (it.extension == "swf"))

                }
                .mapTo(ArrayList()) { it }
    }

    /**
     * 检索视频文件
     */
    fun searchVfForHead(file: File = Environment.getExternalStorageDirectory()): ArrayList<File> {
        val videKeyMap = DfaMatch.createSensitiveMapBytes(createHeaderList())
        val resultList = arrayListOf<File>()
        return file.walk().maxDepth(Int.MAX_VALUE).filter {
            var isVideo = false
            if (it.isFile) {
                //读取文件头
                val headBuffer = ByteArray(16)
                val inputStream = it.inputStream()
                inputStream.read(headBuffer)
                inputStream.close()
                DfaMatch.searchSensitiveMapBytes(headBuffer, videKeyMap) { startPosition, bytes ->
                    run {
                        val resultArray = bytes.toByteArray()
                        when (startPosition) {
                            0 -> isVideo = (resultArray.contentEquals(t_rmvb)
                                    || resultArray.contentEquals(t_mpeg))
                                    || (resultArray.contentEquals(t_wmf_1)
                                    || resultArray.contentEquals(t_wmf_2))

                            4 -> isVideo = (resultArray.contentEquals(t_3gp_1))
                                    || (resultArray.contentEquals(t_3gp_2)
                                    || resultArray.contentEquals(t_3gp_3)
                                    || resultArray.contentEquals(t_mp4_1)
                                    || resultArray.contentEquals(t_mp4_2))
                            8 -> isVideo = resultArray.contentEquals(t_avi)
                        }
                    }
                }
            }
            isVideo
        }.mapTo(resultList) { it }
    }

    /**
     *头匹配方式搜索视频文件
     *已经扩展
     *\.RMF     0   rm/rmvb
     *\x00\x00\x01\xBA          0   mpeg
     *\xD7\xCD\xC6\x9A\x00\x00  0   wmf
     *\x01\x00\x09\x00\x00\x03  0   wmf
     *
     *ftyp3gp   4   3gp
     *ftypmmp4  4   3gp
     *ftypisom  4   3gp
     *ftypmp42  4   mp4
     *ftypdash  4   mp4
     *AVI LIST  8   avi
     *
     *以下格式不常见不做扩展
     *FLV\x01[\x01\x04\x05\x0D] 0   flv
     *\x30\x26\xB2\x75\x8E\x66\xCF\x11\xA6\xD9\x00\xAA\x00\x62\xCE\x6C  0 asf
     *[CF]WS[\x02-\x15]         0   swf
     */
    fun createHeaderList(): ArrayList<ByteArray> {
        return arrayListOf(t_rmvb, t_mpeg, t_wmf_1, t_wmf_2, t_3gp_1, t_3gp_2, t_3gp_3, t_mp4_1, t_mp4_2, t_avi)
    }

    companion object {
        val t_rmvb = byteArrayOf(0x2e, 0x52, 0x4d, 0x46)
        val t_mpeg = byteArrayOf(0x00, 0x00, 0x01, 0xba.toByte())
        val t_wmf_1 = byteArrayOf(0xd7.toByte(), 0xcd.toByte(), 0xc6.toByte(), 0x9a.toByte(), 0x00, 0x00)
        val t_wmf_2 = byteArrayOf(0x01, 0x00, 0x09, 0x00, 0x00, 0x03)
        val t_3gp_1 = byteArrayOf(0x66, 0x74, 0x79, 0x70, 0x33, 0x67, 0x70)

        val t_3gp_2 = byteArrayOf(0x66, 0x74, 0x79, 0x70, 0x6d, 0x6d, 0x70, 0x34)
        val t_3gp_3 = byteArrayOf(0x66, 0x74, 0x79, 0x70, 0x69, 0x73, 0x6F, 0x6D)
        val t_mp4_1 = byteArrayOf(0x66, 0x74, 0x79, 0x70, 0x6d, 0x70, 0x34, 0x32)
        val t_mp4_2 = byteArrayOf(0x66, 0x74, 0x79, 0x70, 0x64, 0x61, 0x73, 0x68)

        val t_avi = byteArrayOf(0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54)
    }
}