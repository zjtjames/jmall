package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.User;

// I开头表示Interface 表示是一个接口 接口扩展性强
public interface IUserService {

    ServerResponse<User> login(String username, String password); //登录

    ServerResponse<String> register(User user); // 注册
}
