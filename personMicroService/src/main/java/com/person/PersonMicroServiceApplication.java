package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.person.config.DBConfig;
import com.person.config.RedisConfig;


@ComponentScan(
		  value = {
		    "com.person.mapper",
		    "com.person.controller",
		    "com.person.repository",
		    "com.person.config",
		    "com.person.service",
		    //"com.person.filter",
		    "com.person.hystrix",
		    " com.person.remote.jms"
		    
		  }
		)
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableResourceServer
@EnableBinding(Source.class)
@Import({ RedisConfig.class , DBConfig.class})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

public class PersonMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroServiceApplication.class, args);
	}
}
