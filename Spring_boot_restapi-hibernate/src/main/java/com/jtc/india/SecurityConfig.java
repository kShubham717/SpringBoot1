package com.jtc.india;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SecurityConfig {
	
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception {
	 * http.csrf().disable().authorizeHttpRequests().requestMatchers(
	 * "/getAllproduct"). permitAll().anyRequest().authenticated().
	 * 
	 * and().formLogin();
	 * 
	 * return http.build(); }
	 */
	 


}
