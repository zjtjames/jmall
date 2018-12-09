package com.jmall.dao;

import com.jmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 看用户是否已经存在
    int checkUsername(String username);

    // mybatis在传递多个参数时要用@Param注解 注解的内容就是sql中的引用名
    User selectLogin(@Param("username1") String username, @Param("password1") String password);

    // 看邮箱是否已经存在
    int checkEmail(String email);

}