package com.nie.nieapp.ftp

import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPClientConfig
import org.apache.commons.net.ftp.FTPReply
import java.io.File
import java.io.IOException
import java.io.InputStream

/**
 * 说明：hostName:服务器名. userName:用户名 password:密码. serverPort:端口号 shareDir:共享文件夹
 * Created by code_nil on 2018/1/19.
 * 君子自强不息
 */
class FTP {
    var hostName: String = "video.xlysoft.com"
    var userName: String = "video_trans"
    var password: String = "123456"
    var serverPort: Int = FTPClient.DEFAULT_PORT
    var shareDir: String = "video"
    /**
     * FTP连接.
     */
    private val ftpClient: FTPClient = FTPClient()


    fun init(hostName: String, userName: String, password: String, shareDir: String = "", serverPort: Int = FTPClient.DEFAULT_PORT) {
        this.hostName = hostName
        this.userName = userName
        this.password = password
        this.shareDir = shareDir
        this.serverPort = serverPort
    }

    /**
     * 上传单个文件.
     *
     * @param localFile 本地文件
     * @return true上传成功, false上传失败
     * @throws IOException
     */
    @Throws(IOException::class)
    internal fun uploadingSingle(localFile: File, `is`: InputStream) {
        ftpClient.storeFile(File.separator + shareDir + File.separator + localFile.name, `is`)
    }

    @Throws(IOException::class)
    internal fun downloadSingle(path: String, localSize: Long): InputStream? {
        ftpClient.restartOffset = localSize//定位到指定位置
        return ftpClient.retrieveFileStream(path)
    }

    /**
     * 上传文件之前初始化相关参数
     *
     * @param remotePath FTP目录
     * @throws IOException
     */
    @Throws(IOException::class)
    internal fun beforeOperate(remotePath: String): Boolean {
        var beforeOperate = true
        // 打开FTP服务
        try {
            this.openConnect()
        } catch (e1: IOException) {
            e1.printStackTrace()
            beforeOperate = false
        }

        // 设置模式
        ftpClient.setFileTransferMode(org.apache.commons.net.ftp.FTP.STREAM_TRANSFER_MODE)
        // FTP下创建文件夹
        ftpClient.makeDirectory(remotePath)
        // 改变FTP目录
        ftpClient.changeWorkingDirectory(remotePath)
        return beforeOperate
    }

    /**
     * 上传完成之后关闭连接
     *
     * @throws IOException
     */
    internal fun afterOperate(): Boolean {
        var afterFlag = true
        try {
            this.closeConnect()
        } catch (e: IOException) {
            e.printStackTrace()
            afterFlag = false
        }

        return afterFlag
    }


    // -------------------------------------------------------打开关闭连接------------------------------------------------

    /**
     * 打开FTP服务.
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun openConnect() {
        // 中文转码
        ftpClient.controlEncoding = "UTF-8"
        // 连接至服务器
        ftpClient.connect(hostName, serverPort)
        var reply: Int = ftpClient.replyCode // 服务器响应值
        // 获取响应值
        if (!FTPReply.isPositiveCompletion(reply)) {
            // 断开连接
            ftpClient.disconnect()
            throw IOException("connect fail: " + reply)
        }
        // 登录到服务器
        ftpClient.login(userName, password)
        // 获取响应值
        reply = ftpClient.replyCode
        if (!FTPReply.isPositiveCompletion(reply)) {
            // 断开连接
            ftpClient.disconnect()
            throw IOException("connect fail: " + reply)
        } else {
            // 获取登录信息
            val config = FTPClientConfig(ftpClient.systemType.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0])
            config.serverLanguageCode = "zh"
            ftpClient.configure(config)
            // 使用被动模式设为默认
            ftpClient.enterLocalPassiveMode()
            // 二进制文件支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)
            //缓冲buffer每次50K，直接影响
            ftpClient.bufferSize = 1024 * 64
        }
    }

    /**
     * 关闭FTP服务.
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun closeConnect() {
        // 退出FTP
        ftpClient.logout()
        // 断开连接
        ftpClient.disconnect()
    }


}
