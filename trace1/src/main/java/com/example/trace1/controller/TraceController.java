package com.example.trace1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceController {
	
    private final Logger logger = LoggerFactory.getLogger(TraceController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/trace-1")
    public String trace() {
    	logger.info("===call trace-1===");
    	return restTemplate.getForEntity("http://trace-2/trace-2", String.class).getBody();
    }

}
