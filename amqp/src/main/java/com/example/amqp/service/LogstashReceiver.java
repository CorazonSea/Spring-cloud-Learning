package com.example.amqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "ichub_log")
public class LogstashReceiver {
	
	@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
	
	

}
