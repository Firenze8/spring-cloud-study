package com.csii.springcloudbusamqp.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/29 - 14:44 -- 星期三
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(){
        String context = "hello!"+ LocalDate.now();
        System.err.println("发送消息 ->"+context);
        this.amqpTemplate.convertAndSend(context);
    }
}
