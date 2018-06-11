/**
 * 
 */
package com.person.dto.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
/**
 * @author chandresh.mishra
 *
 */
@Configuration
public class OrganizationClientConfig {
	
	
	/*@Bean
    public  OrganizationClient feignContract() {
		
		return Feign.builder().logLevel(Logger.Level.FULL)
	            .errorDecoder(new OrganizationErrorDecoder()).target(OrganizationClient.class, "http://organizationService");
    }*/
	
	
	@Bean
    public  ErrorDecoder errorDecoder() {
		
		return new OrganizationErrorDecoder();
    }
	
	 /*@Bean
	    @ConditionalOnProperty(name = "enable.security", havingValue = "true")
	    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(
	        @Value("${remote.person-service.user.name}") String username,
	        @Value("${remote.person-service.user.password}") String password) {

	      return new BasicAuthRequestInterceptor(username, password);
	    }*/
	 
	 @Bean
	    Logger.Level feignLoggerLevel() {
	        return Logger.Level.FULL;
	        
	    }
	 
	  

}
