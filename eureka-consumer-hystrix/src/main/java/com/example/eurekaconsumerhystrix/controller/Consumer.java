package com.example.eurekaconsumerhystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eurekaconsumerhystrix.service.ConsumerService;

@RestController
public class Consumer {
	
	@Autowired
	private ConsumerService consumerService;
	
    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }


}
