/**
 * created by Zheng Jiateng on 2019/1/8.
 */
package com.jmall.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {

    // 静态方法只能调用静态成员 所以这里要设置成静态
    private static Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIP = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.server.user");
    private static String ftpPassword = PropertiesUtil.getProperty("ftp.server.password");

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    private String ip;
    private int port;
    private String user;
    //密码
    private String pwd;
    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIP, 21, ftpUser, ftpPassword);
        logger.info("开始连接ftp服务器");
        //传到ftp服务器文件夹下的img文件夹里
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("结束上传，上传结果{}", result);
        return result;
    }

    /**
     * 封装上传的具体逻辑，只对外暴露上面的public方法
     * @param remotePath ftp服务器默认文件夹下的子文件夹路径
     * @param fileList
     * @return
     */
    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fileInputStream = null;
        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                //修改工作目录
                ftpClient.changeWorkingDirectory(remotePath);
                //设置缓冲区
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                //设置文件类型 二进制类型 防止乱码
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                // 打开本地的被动模式
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fileInputStream = new FileInputStream(fileItem);
                    // 将本地文件上传到ftp服务器
                    ftpClient.storeFile(fileItem.getName(), fileInputStream);
                }
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                uploaded = false;
            } finally {
                // 释放连接
                fileInputStream.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    //封装连接服务器
    private boolean connectServer(String ip, int port, String user, String Password) {
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, Password);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }

}
