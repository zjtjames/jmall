package com.jmall.ioc.interfaces;

import com.jmall.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceImplTest extends UnitTestBase {

    public OneInterfaceImplTest() {
        super("classpath*:spring-ioc.xml");
    }

    @Test
    public void hello() throws Exception {
        OneInterface oneInterface = super.getBean("oneInterface");
        System.out.println(oneInterface.hello("huangfeihong"));
    }

}