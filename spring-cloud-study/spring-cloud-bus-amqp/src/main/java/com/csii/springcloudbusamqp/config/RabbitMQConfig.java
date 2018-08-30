package com.csii.springcloudbusamqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/29 - 14:49 -- 星期三
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("Hello");
    }
}
