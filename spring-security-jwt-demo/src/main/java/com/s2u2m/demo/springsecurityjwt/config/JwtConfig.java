package com.s2u2m.demo.springsecurityjwt.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Bean
    public Algorithm algorithm() {
        return Algorithm.HMAC512("SECRET_KEY".getBytes());
    }
}
