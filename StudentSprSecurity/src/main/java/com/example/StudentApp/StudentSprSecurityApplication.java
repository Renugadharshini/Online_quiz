package com.example.StudentApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableJpaRepositories("com.example.StudentApp.repo")
@EntityScan("com.example.StudentApp.beans")
@ComponentScan(basePackages = {"com.example.StudentApp.web","com.example.StudentApp.service","com.example.StudentApp.config"})
//@SpringBootApplication
public class StudentSprSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSprSecurityApplication.class, args);
	}

}
