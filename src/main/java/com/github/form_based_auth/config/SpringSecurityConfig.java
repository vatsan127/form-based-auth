package com.github.form_based_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public UserDetailsService defaultUsers() {
        UserDetails user1 = User.withUsername("srivatsan")
                .password(new BCryptPasswordEncoder().encode("password"))
                .roles("Admin")
                .build();

        UserDetails user2 = User.withUsername("default")
                .password(new BCryptPasswordEncoder().encode("default-password"))
                .roles("default")
                .build();

        UserDetails user3 = User.withUsername("admin")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .roles("Admin")
                .build();


        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    public PasswordEncoder defaultPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
