/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.service.impl;

import com.jmall.common.ServerResponse;
import com.jmall.dao.UserMapper;
import com.jmall.pojo.User;
import com.jmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        // 看用户是否存在
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        //todo 密码登录MD5 让密码在数据库中不明文保存


        return null;
    }
}
