/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public Object login(String username, String password, HttpSession session) {

        //service-->mybatis->dao
        return null;
    }
}
