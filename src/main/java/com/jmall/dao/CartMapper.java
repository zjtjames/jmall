package com.jmall.dao;

import com.jmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record); // 有字段的空判断，非空才插入

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record); // 有字段的空判断，非空才插入

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<Cart> selectCartByUserId(Integer userId);
}