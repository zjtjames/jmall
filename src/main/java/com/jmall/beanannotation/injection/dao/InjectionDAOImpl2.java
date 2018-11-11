/**
 * created by Zheng Jiateng on 2018/11/11.
 */
package com.jmall.beanannotation.injection.dao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

@Order(1)
@Repository
public class InjectionDAOImpl2 implements InjectionDAO {

    @Override
    // 模拟数据库保存操作
    public void save(String arg) {
        System.out.println("dao2保存数据:" + arg);
    }
}
