package com.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.config.JWTOAuth2Config;
import com.auth.jwt.config.WebSecurityConfigurer;

@SpringBootApplication( exclude = {
		  SecurityAutoConfiguration.class		
})
@EnableAuthorizationServer
@RestController
//@EnableResourceServer
@Import(
		  value = {
		    JWTOAuth2Config.class,
		    WebSecurityConfigurer.class
		  }
		)
@EnableEurekaClient
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@GetMapping(value = { "/oauth/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
		
        Map<String, Object> userInfo = new HashMap<>();
        
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }
}
