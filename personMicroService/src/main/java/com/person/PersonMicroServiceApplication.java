package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
		  value = {
		    "com.person.mapper",
		    "com.person.controller",
		    "com.person.repository",
		    "com.person.config",
		    "com.person.service"
		  }
		)
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class PersonMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroServiceApplication.class, args);
	}
}
