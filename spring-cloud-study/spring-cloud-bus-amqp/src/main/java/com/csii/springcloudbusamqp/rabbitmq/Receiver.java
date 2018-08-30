package com.csii.springcloudbusamqp.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/29 - 14:47 -- 星期三
 */
@Component
@RabbitListener(queues = "Hello")
public class Receiver {

    @RabbitHandler
    public void handle(String hello){
        System.err.println("Receive -> "+hello);
    }
}
