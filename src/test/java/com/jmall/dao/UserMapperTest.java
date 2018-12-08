package com.jmall.dao;

import com.jmall.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperTest {


    @Test
    public void insert() throws Exception {
        User me = new User();
        me.setUsername("james");
        me.setAnswer("5555");

    }
}