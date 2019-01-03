/**
 * created by Zheng Jiateng on 2018/12/4.
 */
package com.jmall.controller.portal;

import com.jmall.common.Const;
import com.jmall.common.ResponseCode;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.User;
import com.jmall.service.IUserService;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/") // 最后一个/可有可无
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

    @RequestMapping(value = "logout.do",method = RequestMethod.POST) // 登出
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> logout(HttpSession session) {
        // 登出就是在session中把添加的currentUser删除掉
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST) // 注册
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }

    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST) // 校验用户名或邮箱是否已存在
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST) // 获取用户登录信息
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            user.setPassword(StringUtils.EMPTY);
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }

    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST) // 获取修改密码问题
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }


    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST) // 校验问题答案是否正确
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return iUserService.checkAnswer(username, question, answer);
    }

    @RequestMapping(value = "forget_reset_password.do", method = RequestMethod.POST) // 忘记密码中的重置密码
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }

    @RequestMapping(value = "reset_password.do", method = RequestMethod.POST) // 登录状态的重置密码
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew) { // 因为要判断登录状态 所以要传入httpsession
        User user = (User) session.getAttribute(Const.CURRENT_USER); // 登录的时候把user存进了session
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld, passwordNew, user);
    }

    @RequestMapping(value = "update_information.do", method = RequestMethod.POST) // 登录状态下更新用户信息
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<User> updateInformation(HttpSession session, User user) { // 前端表单传进来的user带的属性是要更新的邮箱、电话、问题等 里面不含id username
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername()); // 密码不存入session中
        ServerResponse<User> response = iUserService.updateInformation(user);
        // 更新session
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "get_information.do", method = RequestMethod.POST) //获取当前登录用户的详细信息，如果调用着这个接口后，发现用户未登录，要强制登录
    @ResponseBody // 自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要强制登录status=10");
        }
//        return iUserService.getInformation(currentUser.getId());
        return getUserInfo(session);
    }



}
