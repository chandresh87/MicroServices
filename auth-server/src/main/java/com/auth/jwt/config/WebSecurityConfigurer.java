package com.auth.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

	   UserDetails user=User.builder().username("john.doe").password(passwordEncoder().encode("password1")).
   			roles("USER").build();
   	UserDetails userAdmin=User.builder().username("chandresh.mishra").password(passwordEncoder().encode("password1")).
   			roles("USER", "ADMIN").build();
       return new InMemoryUserDetailsManager(user,userAdmin);
   }
   
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new  BCryptPasswordEncoder();
   }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	// support in memory ,jdbc and ldap
//        auth
//                .inMemoryAuthentication()
//                .withUser("john.doe").password("{noop}password1").roles("USER")
//                .and()
//                .withUser("chandresh.mishra").password("{noop}password1").roles("USER", "ADMIN");
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();
    }
}
