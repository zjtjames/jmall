package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.User;

// I开头表示Interface 表示是一个接口 接口扩展性强
public interface IUserService {

    ServerResponse<User> login(String username, String password); //登录

    ServerResponse<String> register(User user); // 注册

    ServerResponse<String> checkValid(String str, String type); // 校验是否已存在

    ServerResponse<String> selectQuestion(String username); // 获取密码找回问题

    ServerResponse<String> checkAnswer(String username, String question, String answer); // 检验密码找回答案是否正确

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken); // 忘记密码中的重置密码

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user); // 登录状态下修改密码
}
