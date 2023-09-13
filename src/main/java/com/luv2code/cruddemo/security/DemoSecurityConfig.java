package com.luv2code.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// https://www.baeldung.com/spring-bean
@Configuration
public class DemoSecurityConfig {

    // add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")

        );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST API's that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails lee = User.builder()
//                .username("lee")
//                .password("{noop}password123") // {noop} = no operation, store password as plain text
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails zac = User.builder()
//                .username("zac")
//                .password("{noop}password123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails yasuo = User.builder()
//                .username("yasuo")
//                .password("{noop}password123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(lee, zac, yasuo);
//    }

/**
 * Some Ideas,
 * 1. Create a logging system to see when a user attempts to send an HTTP command that they are not allowed to use
 *    Or make the program log all the employee's requests, so there exists a log of what everyone does
 * 2.
 */