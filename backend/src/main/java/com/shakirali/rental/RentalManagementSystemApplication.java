package com.shakirali.rental;

import com.shakirali.rental.entity.Property;
import com.shakirali.rental.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementSystemApplication.class, args);
	}

}
