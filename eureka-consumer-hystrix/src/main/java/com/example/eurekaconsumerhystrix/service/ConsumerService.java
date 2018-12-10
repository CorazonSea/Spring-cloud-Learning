package com.example.eurekaconsumerhystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eurekaconsumerhystrix.client.EurekaClientFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	@Autowired
	private EurekaClientFeign eurekaClient;
	
	//服务降级
	@HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return eurekaClient.dc();
    }

    public String fallback() {
        return "fallback";
    }
}
