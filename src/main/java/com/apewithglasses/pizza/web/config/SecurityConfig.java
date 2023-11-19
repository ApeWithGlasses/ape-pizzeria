package com.apewithglasses.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    // Allows all the http request
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .anyRequest()
                                    .authenticated();
                        }
                )
                .csrf(AbstractHttpConfigurer::disable)
                .cors(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }
}
