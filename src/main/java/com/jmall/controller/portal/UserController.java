/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.controller.portal;

import com.jmall.common.Const;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.User;
import com.jmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired  //依赖注入
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST) // 登录
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.GET) // 登出
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> logout(HttpSession session) {
       // 登出就是在session中把添加的currentUser删除掉
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do",method = RequestMethod.GET) // 注册
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }
}
