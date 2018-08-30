package com.csii.springcloudbusamqp;

import com.csii.springcloudbusamqp.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudBusAmqpApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudBusAmqpApplication.class, args);
	}
}
