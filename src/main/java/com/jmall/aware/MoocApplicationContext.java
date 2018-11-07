/**
 * created by Zheng Jiateng on 2018/11/7.
 */
package com.jmall.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoocApplicationContext implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("MoocApplicationContext: " + applicationContext.getBean("moocApplicationContext").hashCode());

    }

    public void a() {
//        this.applicationContext
    }
}
