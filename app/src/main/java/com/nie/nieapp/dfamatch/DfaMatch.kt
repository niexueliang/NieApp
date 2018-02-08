package com.nie.nieapp.dfamatch

import android.util.Log

/**
 * 说明：DFA关键词过滤
 * Created by code_nil on 2018/2/2.
 * 君子自强不息
 */
object DfaMatch {
    fun createSensitiveMap(keyArray: Array<String>): HashMap<Any, Any> {
        //创建基础map，减少扩容
        val sensitiveMap = HashMap<Any, Any>(keyArray.size)
        //迭代构建词库
        val tempIterator = keyArray.iterator()
        while (tempIterator.hasNext()) {
            val keyArray = tempIterator.next().toCharArray()
            val keyIterator = keyArray.iterator()
            //切换字符串时，每次开始均是从根节点开始
            var nowMap = sensitiveMap
            while (keyIterator.hasNext()) {
                val tempChar = keyIterator.nextChar()
                val nextMap = nowMap[tempChar]
                //判定该字节是否加入子map
                nowMap = if (nextMap != null) {//已经加入子map，表示不用重复添加，那么将nowmap置为本节点的map
                    nextMap as HashMap<Any, Any>
                } else {//当未存在时证明需要添加新的子map
                    val nextMap = HashMap<Any, Any>()//创建新map
                    nextMap["end"] = false//设置节点未结束false
                    nowMap[tempChar] = nextMap//设置新map
                    nextMap //将本次节点置为新创建的节点
                }
            }
            //遍历结束，将标志位置为true，表示该关键字完全存入字典中
            nowMap["end"] = true
        }
        return sensitiveMap
    }

    fun searchSensitive(data: String, keyMap: HashMap<Any, Any>) {
        val stringBuilder = StringBuilder()
        for (i in 0 until data.length) {
            stringBuilder.setLength(0)
            var tempMap = keyMap
            for (j in i until data.length) {
                val keyChar = data[j]
                val nextMap = tempMap[keyChar]
                if (nextMap != null) {//查到一个关键字
                    nextMap as HashMap<Any, Any>
                    //添加字符
                    stringBuilder.append(keyChar)
                    //获取当前字符是否为最后一个字符
                    tempMap = if (nextMap["end"] as Boolean) {
                        Log.e("searchSensitive", stringBuilder.toString())
                        stringBuilder.setLength(0)
                        keyMap
                    } else {
                        nextMap
                    }
                } else {
                    break
                }
            }
        }
    }


    fun createSensitiveMapBytes(keyArray: ArrayList<ByteArray>): HashMap<Any, Any> {
        //创建基础map，减少扩容
        val sensitiveMap = HashMap<Any, Any>(keyArray.size)
        //迭代构建词库
        val tempIterator = keyArray.iterator()
        while (tempIterator.hasNext()) {
            val keyArray = tempIterator.next()
            val keyIterator = keyArray.iterator()
            //切换字符串时，每次开始均是从根节点开始
            var nowMap = sensitiveMap
            while (keyIterator.hasNext()) {
                val tempByte = keyIterator.nextByte()
                val nextMap = nowMap[tempByte]
                //判定该字节是否加入子map
                nowMap = if (nextMap != null) {//已经加入子map，表示不用重复添加，那么将nowmap置为本节点的map
                    nextMap as HashMap<Any, Any>
                } else {//当未存在时证明需要添加新的子map
                    val nextMap = HashMap<Any, Any>()//创建新map
                    nextMap["end"] = false//设置节点未结束false
                    nowMap[tempByte] = nextMap//设置新map
                    nextMap //将本次节点置为新创建的节点
                }
            }
            //遍历结束，将标志位置为true，表示该关键字完全存入字典中
            nowMap["end"] = true
        }
        return sensitiveMap
    }

    fun searchSensitiveMapBytes(data: ByteArray, keyMap: HashMap<Any, Any>, action: (Int, ArrayList<Byte>) -> Unit) {
        val byteResult = arrayListOf<Byte>()
        for (i in 0 until data.size) {
            byteResult.clear()   //重置数据
            var tempMap = keyMap     //重置字典
            for (j in i until data.size) {
                val keyChar = data[j]
                val nextMap = tempMap[keyChar]
                if (nextMap != null) {//查到一个关键字
                    nextMap as HashMap<Any, Any>
                    //添加字符
                    byteResult.add(keyChar)
                    //获取当前字符是否为最后一个字符
                    tempMap = if (nextMap["end"] as Boolean) {
                        action(i, byteResult)
                        byteResult.clear()
                        keyMap
                    } else {
                        nextMap
                    }
                } else {
                    break//跳出循环j
                }
            }
        }
    }
}
