package com.nongshim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BananasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BananasApplication.class, args);
	}

}
