package com.example.furama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FuramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuramaApplication.class, args);
	}

}
