package com.smart.auth.config;

import com.smart.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AuthConfig {

    @Bean
    public UserDetailsService userDetailsService(@Autowired UserService userService) {
        return userService::loadUserByUsername;
    }
}
