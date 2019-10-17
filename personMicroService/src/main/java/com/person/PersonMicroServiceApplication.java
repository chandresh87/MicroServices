package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.person.config.DBConfig;
import com.person.config.RedisConfig;

@ComponentScan(value = { "com.person.mapper", "com.person.controller", "com.person.repository", "com.person.config",
		"com.person.service",
		// "com.person.filter",
		"com.person.hystrix", " com.person.remote.jms"

})
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableResourceServer
//@EnableBinding(Source.class)
@Import({ DBConfig.class,RedisConfig.class})

public class PersonMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroServiceApplication.class, args);
	}
}
