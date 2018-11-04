/**
 * created by Zheng Jiateng on 2018/11/4.
 */
package com.jmall.ioc.injection.dao;

public class InjectionDAOImpl implements InjectionDAO {

    @Override
    // 模拟数据库保存操作
    public void save(String arg) {
        System.out.println("保存数据:" + arg);
    }
}
