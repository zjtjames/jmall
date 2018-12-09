/**
 * created by Zheng Jiateng on 2018/12/9.
 */
package com.jmall.common;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    // 技巧 使用内部接口类对常量进行分组 这样比定义枚举轻量一些
    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员
    }
}
