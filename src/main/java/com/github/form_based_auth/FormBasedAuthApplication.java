package com.github.form_based_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class FormBasedAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormBasedAuthApplication.class, args);
	}

}
