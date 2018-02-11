package com.nie.nieapp.websocket

import java.io.File
import java.net.URI
import java.util.*
import java.util.concurrent.Executors

/**
 * 说明：
 * Created by code_nil on 2018/2/1.
 * 君子自强不息
 */
class WsSocket{
    private val hostName = "192.168.0.123"
    private val port = "9527"
    private val uri = "ws://$hostName:$port/BobTest"
    private val wsClient = SpiWSClient(URI.create(uri)){
        //处理事件
    }
    private val bufferSize = 1024 * 1024
    //线程池
    private val singleExecutors = Executors.newSingleThreadExecutor()


    //建立ws连接
    fun connect() {
        singleExecutors.execute {
            wsClient.connect()
        }
    }

    //关闭连接
    fun close() {
        wsClient.close()
    }


    fun sendData(data: String) {
        wsClient.send(data)
    }

    fun sendFile(path: String) {
        val file = File(path)
        file.forEachBlock(bufferSize) { buffer, bytesRead ->
            if (bytesRead != bufferSize) {
                wsClient.send(Arrays.copyOf(buffer, bytesRead))
            } else {
                wsClient.send(buffer)
            }
        }
    }

}