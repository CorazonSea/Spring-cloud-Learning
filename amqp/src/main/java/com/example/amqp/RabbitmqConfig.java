package com.example.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
	//final static String queueName = "logstash";

   /* @Bean
    public Queue helloQueue() {
        return new Queue("q_logstash");
    }*/
	
    //===============以下是验证topic Exchange的队列==========
    @Bean
    public Queue queueMessage() {
        return new Queue("ichub_log");
    }

    /*@Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }*/
  //===============以上是验证topic Exchange的队列==========
    
    
    //===============以下是验证Fanout Exchange的队列==========
   /* @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }*/
    //===============以上是验证Fanout Exchange的队列==========
    

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("ichub_log_exchange");
    }
   /* @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    //===============以上是验证Direct Exchange的队列==========
    @Bean
    DirectExchange directExchange(){
    	 return new DirectExchange("ex_logstash");
    }*/

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("#");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
   /* @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
    
    @Bean
    Binding bindingDirectExchangeMessages(Queue helloQueue, DirectExchange exchange) {
        return BindingBuilder.bind(helloQueue).to(exchange).with("logstash.#");
    }*/
}
