/**
 * 
 */
package com.person.dto.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;

/**
 * @author chandresh.mishra
 *
 */
@Configuration
public class OrganizationClientConfig {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;

	}

	@Bean
	public ErrorDecoder errorDecoder() {

		return new OrganizationErrorDecoder();
	}

	@Bean
	public RequestInterceptor getUserFeignClientInterceptor() {
		return new UserFeignClientInterceptor();
	}

}
