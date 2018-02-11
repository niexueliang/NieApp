package com.nie.nieapp.net

import android.content.Context
import java.io.FileInputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory

/**
 * 说明：
 * Created by code_nil on 2018/2/11.
 * 君子自强不息
 */
object SslFactory {
    fun createFactory(context: Context, name: String): SSLSocketFactory {
        // 取到证书的输入流    anchor.crt为raw文件夹下面的文件

        val fis = context.assets.open(name)
        val cf = CertificateFactory.getInstance("X.509")
        val ca = cf.generateCertificate(fis)

        // 创建 Keystore 包含我们的证书
        val keyStoreType = KeyStore.getDefaultType()
        val keyStore = KeyStore.getInstance(keyStoreType)
        keyStore.load(null)
        keyStore.setCertificateEntry("anchor", ca)

        // 创建一个 TrustManager 仅把 Keystore 中的证书 作为信任的锚点
        val algorithm = TrustManagerFactory.getDefaultAlgorithm()
        val trustManagerFactory = TrustManagerFactory.getInstance(algorithm)
        trustManagerFactory.init(keyStore)
        val trustManagers = trustManagerFactory.trustManagers

        // 用 TrustManager 初始化一个 SSLContext
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagers, null)
        return sslContext.socketFactory
    }
}