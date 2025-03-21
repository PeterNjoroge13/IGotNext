package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
 *  This class is meant to definding a hashing algorithim that will encrypt users
            passwords
 */

//marks this classes as a configuration file
@Configuration
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
}
