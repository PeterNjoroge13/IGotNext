package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/*
 *  This class is meant to definding a hashing algorithim that will encrypt users
            passwords
 */

//marks this classes as a configuration file
@Configuration
@EnableWebSecurity // Enables Spring Security for the application
public class SecurityConfig {
    /*  
     * Bean defines passwordEncoder as an object that is a spring managed componet
     * Bean is a instance of a class that Spring made basically
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
            //secure hashing algorithim that encrypts passwords
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean // Defines the security filter chain for HTTP requests
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disables CSRF protection (useful for testing, enable in production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users", "/api/auth/login").permitAll() // Allows public access to these endpoints
                .anyRequest().authenticated() // Requires authentication for all other endpoints
            )
            .httpBasic(httpBasic -> {}); // Enables basic authentication (username and password)

        return http.build(); // Builds and returns the security configuration
    }
}
