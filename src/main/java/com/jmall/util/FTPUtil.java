/**
 * created by Zheng Jiateng on 2019/1/8.
 */
package com.jmall.util;

public class FTPUtil {

    private static String ftpIP = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.server.user");
    private static String ftpPassword = PropertiesUtil.getProperty("ftp.server.password");
}
