package com.spring.rest.webservices.restfulapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration{

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //1. All requests should be authenticated
    http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());

    //2. If request is not authenticated, a web page is shown
    http.httpBasic(withDefaults());

    return http.build();
  }


}
