package com.jmall.aware;

import com.jmall.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class MoocApplicationContextTest extends UnitTestBase{

    public MoocApplicationContextTest() {
        super("classpath*:spring-aware.xml");
    }

    @Test
    public void testMoocApplicationContext() {
        System.out.println("testMoocApplicationContext: " + super.getBean("moocApplicationContext").hashCode());
    }

}