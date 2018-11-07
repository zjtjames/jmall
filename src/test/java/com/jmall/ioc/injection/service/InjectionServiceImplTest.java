package com.jmall.ioc.injection.service; 

import com.jmall.base.UnitTestBase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/** 
* InjectionServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>11/05/2018</pre> 
* @version 1.0 
*/

@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionServiceImplTest extends UnitTestBase{

    public InjectionServiceImplTest() {
        super("classpath*:spring-injection.xml");
    }

/** 
* 
* Method: setInjectionDAO(InjectionDAO injectionDAO) 
* 
*/ 
@Test
public void testSetter() throws Exception {
    InjectionService service = super.getBean("injectionService");
    service.save("huangfeihong");
}

@Test
public void testConstructor() throws Exception {
    InjectionService service = super.getBean("injectionService");
    service.save("huangfeihong");
}
/** 
* 
* Method: save(String arg) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 


} 
