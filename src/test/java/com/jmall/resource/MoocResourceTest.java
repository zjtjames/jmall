package com.jmall.resource;

import com.jmall.base.UnitTestBase;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MoocResourceTest extends UnitTestBase{

    public MoocResourceTest() {
        super("classpath*:spring-resource.xml");
    }

    @Test
    public void testResource() {
        MoocResource resource = super.getBean("moocResource");
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}