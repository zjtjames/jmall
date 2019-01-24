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

    // 如果购物车中所有商品都处于勾选状态 返回0 否则返回1
    int selectCartProductCheckedStatusByUserId(Integer userId);

    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIdList")List<String> productIdList);

    int checkedOrUncheckedPRoduct(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("checked") Integer checked);

    int selectCartProductCount(Integer userId);
}