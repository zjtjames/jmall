package com.jmall.dao;

import com.jmall.pojo.Cart;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record); // 有字段的空判断，非空才插入

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record); // 有字段的空判断，非空才插入

    int updateByPrimaryKey(Cart record);
}