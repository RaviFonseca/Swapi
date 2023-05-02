package com.example.Swapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SwapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapiApplication.class, args);
	}

}
