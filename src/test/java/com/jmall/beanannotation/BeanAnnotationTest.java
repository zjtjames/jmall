package com.jmall.beanannotation;

import com.jmall.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanAnnotationTest extends UnitTestBase{

    public BeanAnnotationTest() {
        super("classpath*:spring-beanannotation.xml");
    }

    @Test
    public void testSay() {
        BeanAnnotation bean = super.getBean("guaguagua");
        bean.say("huangfeihong");
    }

    @Test
    public void testScope() {
        BeanAnnotation bean = super.getBean("guaguagua");
        bean.myHashCode();
        bean = super.getBean("guaguagua");
        bean.myHashCode();
    }
}