/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.common;

import java.io.Serializable;

public class ServerResponse <T> implements Serializable{ // 定义泛型类 实现序列化接口

    private int status;
    private String msg;
    private T data;

    //构造器设为私有 外部不能new它
    private ServerResponse(int status) {
        this.status = status;
    }

    // 当泛型为String时，会与第四个构造器混淆，所以在public方法中要处理这个冲突
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.status == 0;

    }

}
