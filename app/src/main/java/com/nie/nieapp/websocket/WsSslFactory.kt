package com.nie.nieapp.websocket

import java.io.File
import java.io.FileInputStream
import java.security.KeyStore
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory

/**
 * 说明：
 * Created by code_nil on 2018/2/11.
 * 君子自强不息
 */
object WsSslFactory {
    //需要证书
    fun createSslFactory(): SSLSocketFactory {
        // load up the key store
        val STORETYPE = "JKS"
        val KEYSTORE = "keystore.jks"
        val STOREPASSWORD = "storepassword"
        val KEYPASSWORD = "keypassword"

        val ks = KeyStore.getInstance(STORETYPE)
        val kf = File(KEYSTORE)
        ks.load(FileInputStream(kf), STOREPASSWORD.toCharArray())

        val kmf = KeyManagerFactory.getInstance("SunX509")
        kmf.init(ks, KEYPASSWORD.toCharArray())
        val tmf = TrustManagerFactory.getInstance("SunX509")
        tmf.init(ks)

        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        sslContext.init(kmf.keyManagers, tmf.trustManagers, null)
        return sslContext.socketFactory
    }

    //不需要证书
    fun createDefaultFactory(): SSLSocketFactory {
        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        // will use java's default key and trust store which is sufficient unless you deal with self-signed certificates
        sslContext.init(null, null, null)
        return SSLSocketFactory.getDefault() as SSLSocketFactory
    }
}