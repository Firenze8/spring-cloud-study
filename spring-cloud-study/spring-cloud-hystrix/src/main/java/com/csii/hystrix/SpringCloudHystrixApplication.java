package com.csii.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
//@EnableCircuitBreaker
//@EnableHystrix和@EnableCircuitBreaker这两个注解标注一个即可
@EnableFeignClients
@EnableDiscoveryClient
public class SpringCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixApplication.class, args);
	}
}
