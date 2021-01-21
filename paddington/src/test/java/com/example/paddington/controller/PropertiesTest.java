package com.example.paddington.controller;

import com.example.paddington.util.Properties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private Properties properties;

    @Test
    public void getHello(){
        Assert.assertEquals(properties.getTitle(),"springboot");
        Assert.assertEquals(properties.getDescription(),"每天进步一点点");
    }
}
