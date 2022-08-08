package com.standard.springsecurityexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecurityexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityexampleApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("ADMIN"));
	}

}
