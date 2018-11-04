/**
 * created by Zheng Jiateng on 2018/11/4.
 */
package com.jmall.ioc.injection.service;

import com.jmall.ioc.injection.dao.InjectionDAO;

public class InjectionServiceImpl implements InjectionService {

    private InjectionDAO injectionDAO;

    // 设置注入
    public void setInjectionDAO(InjectionDAO injectionDAO) {
        this.injectionDAO = injectionDAO;
    }

    @Override
    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接受参数" + arg);
        arg = arg + ":" +this.hashCode();
        injectionDAO.save(arg);
    }
}
