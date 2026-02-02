package com.shakirali.remintenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RentalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementSystemApplication.class, args);
	}

}
