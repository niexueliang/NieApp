package com.nie.nieapp.websocket

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import java.lang.Exception
import java.net.URI

/**
 * 说明：
 * Created by code_nil on 2018/1/29.
 * 君子自强不息
 */
class SpiWSClient(uri: URI, private val action: (message: Any) -> Unit) : WebSocketClient(uri), AnkoLogger {
    override fun onOpen(handshakedata: ServerHandshake) {
        error { "onOpen:::::onOpen" }
    }

    override fun onClose(code: Int, reason: String, remote: Boolean) {
        error { "onClose--->$code--->$reason--->$remote" }
    }

    override fun onMessage(message: String) {
        action(message)
    }

    override fun onError(ex: Exception) {
        action("${ex.message}")
        error { "onError---->$ex" }
    }

}