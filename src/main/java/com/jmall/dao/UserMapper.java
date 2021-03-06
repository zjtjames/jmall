package com.jmall.dao;

import com.jmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record); // 返回值是生效的行数

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    // where条件只有一个id
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 看用户是否已经存在
    int checkUsername(String username);

    // 登录
    // mybatis在传递多个参数时要用@Param注解 注解的内容就是sql中的引用名
    User selectLogin(@Param("username") String username, @Param("password") String password);

    // 看邮箱是否已经存在
    int checkEmail(String email);

    // 根据用户名获取密码重置问题
    String selectQuestionByUsername(String username);

    // mybatis在传递多个参数时要用@Param注解 注解的内容就是sql中的引用名
    // 校验答案
    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer")String answer);

    // 更新密码
    int updatePasswordByUsername(@Param("username")String username, @Param("passwordNew")String passwordNew);

    // 校验密码
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    // 看email是否已被其他人占用
    int checkEmailByUserId(@Param("email1")String email, @Param("userId1")Integer userId);

}