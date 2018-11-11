/**
 * created by Zheng Jiateng on 2018/11/11.
 */
package com.jmall.beanannotation.injection.dao;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDAOImpl implements InjectionDAO {

    @Override
    // 模拟数据库保存操作
    public void save(String arg) {
        System.out.println("dao保存数据:" + arg);
    }
}
