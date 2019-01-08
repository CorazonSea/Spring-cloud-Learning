package com.example.amqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "ichub_log")
public class TopicMessageReceiver {
	@RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }

}
