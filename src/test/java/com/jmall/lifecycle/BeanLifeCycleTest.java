package com.jmall.lifecycle;

import com.jmall.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifeCycleTest extends UnitTestBase{

    public BeanLifeCycleTest() {
        super("classpath*:spring-lifecycle.xml");
    }

    @Test
    public void test1() {
        super.getBean("beanLifeCycle");

    }
}