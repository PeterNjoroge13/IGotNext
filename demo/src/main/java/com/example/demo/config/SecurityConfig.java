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
    
    
    /**
     * Configures authentication rules for API endpoints.
     */
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Disable CSRF (enable in production)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/users", "/api/users/**", "/api/auth/login").permitAll() // Allow user registration & login
            .anyRequest().authenticated() // Require authentication for everything else
        )
        .sessionManagement(session -> 
            session.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)) // Use JWT (no sessions)
        .httpBasic(httpBasic -> {}); // Enable basic authentication (optional)

    return http.build(); // Apply security settings
}

}