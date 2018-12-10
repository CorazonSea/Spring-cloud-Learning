package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Test {
	
	@Value("${test}")
    private String test;
	
	@Value("${info.profile}")
    private String profile;

    @RequestMapping("/profile")
    public String info() {
        return this.test + "" + this.profile;
    }
}
