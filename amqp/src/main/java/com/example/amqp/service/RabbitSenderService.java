package com.example.amqp.service;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSenderService {
	@Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender1send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("directExchange", sendMsg);
    }
    
    public void topicSend() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("ichub_log_exchange", "ichub_prod", msg1);
        
       /* String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);*/
    }
    
    
    


}
