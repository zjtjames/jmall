package com.jmall.beanannotation.javabased;

import com.jmall.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreConfigTest extends UnitTestBase{

    public StoreConfigTest() {
        super("classpath*:spring-beanannotation.xml");
    }

    @Test
    public void test() {
        Store store = super.getBean("store");
        System.out.println(store.getClass().getName());
    }

}