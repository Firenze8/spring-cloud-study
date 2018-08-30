package com.csii.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserServiceApplication.class, args);
	}
}
