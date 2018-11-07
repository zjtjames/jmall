package com.jmall.bean;

import com.jmall.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends UnitTestBase {

    // 测试singleton 和 prototype
    public BeanScopeTest() {
        super("classpath*:spring-beanscope.xml");
    }
    @Test
    public void say() throws Exception {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope1 = super.getBean("beanScope");
        beanScope1.say();
    }

    @Test
    public void say2() throws Exception {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();
    }
}