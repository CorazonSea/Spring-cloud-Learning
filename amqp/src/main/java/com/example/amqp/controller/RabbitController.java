package com.example.amqp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amqp.service.RabbitSenderService;

@RestController
public class RabbitController {
	@Autowired
	private RabbitSenderService sender;
	
	@PostMapping("/hello")
	public void hello() {
		sender.sender1send("hello1");
	}
	
	@PostMapping("/topicTest")
    public void topicTest() {
		sender.topicSend();
    }

}


