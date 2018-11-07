package com.jmall.aware;

import com.jmall.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoocBeanNameTest extends UnitTestBase{

    public MoocBeanNameTest() {
        super("classpath*:spring-aware.xml");
    }

    @Test
    public void testMoocBeanName() {
        System.out.println("testMoocBeanName: " + super.getBean("moocBeanName").hashCode());
    }

}