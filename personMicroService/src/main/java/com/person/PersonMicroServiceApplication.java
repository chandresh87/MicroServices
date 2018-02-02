package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableMBeanExport;

@ComponentScan(
		  value = {
		    "com.person.mapper",
		    "com.person.controller",
		    "com.person.repository",
		    "com.person.config"
		    
		  }
		)
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class PersonMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroServiceApplication.class, args);
	}
}
