package com.csii.springcloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringCloudStreamApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(SpringCloudStreamApplication.class).web(true).run(args);
		//SpringApplication.run(SpringCloudStreamApplication.class, args);
	}
}
