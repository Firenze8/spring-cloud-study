package com.csii.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudMovieServiceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMovieServiceApplication.class, args);
	}
}
