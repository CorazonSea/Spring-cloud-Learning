package com.example.paddington.controller;

import com.example.paddington.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijl
 * @date 2021/1/20 上午11:01
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String  getUser() {
        User user=new User();
        user.setUserName("小明");
        user.setPassword("xxxx");
        return "Hello World";
    }
}
