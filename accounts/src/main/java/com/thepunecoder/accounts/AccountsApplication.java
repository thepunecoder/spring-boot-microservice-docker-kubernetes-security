package com.thepunecoder.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

/*
What is @SpringBootApplication annotation in a Spring Boot application?
The @SpringBootApplication annotation is a convenience annotation that combines three commonly used annotations in Spring Boot applications: @Configuration, @EnableAutoConfiguration, and @ComponentScan.
It indicates that the class is the main entry point for the Spring Boot application and triggers auto-configuration, component scanning, and allows defining extra configuration on the application class.

 */