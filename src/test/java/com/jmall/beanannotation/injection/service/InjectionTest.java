package com.jmall.beanannotation.injection.service;

import com.jmall.base.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class InjectionTest extends UnitTestBase{

    public InjectionTest() {
        super("spring-beanannotation.xml");
    }

    @Test
    public void testAutowired() {
        InjectionService service = super.getBean("injectionServiceImpl");
        service.save("This is autowired");
    }


}