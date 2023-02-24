package com.example.demo.userservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .autorizeRequest().anyRequest().permitAll();
    }
}