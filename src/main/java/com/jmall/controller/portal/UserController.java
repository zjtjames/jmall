/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.controller.portal;

import com.jmall.common.Const;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.User;
import com.jmall.service.IUserService;
import net.sf.jsqlparser.schema.Server;
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

    @RequestMapping(value = "check_valid.do",method = RequestMethod.GET) // 校验用户名或邮箱是否已存在
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    @RequestMapping(value = "get_user_info.do",method = RequestMethod.GET) // 获取用户登录信息
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }

    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.GET) // 获取用户登录信息
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }

    // 校验问题答案是否正确
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {

    }

}
