package com.DanidigaDeveloper.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.DanidigaDeveloper.app.entity")
public class PruebaRicohApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaRicohApplication.class, args);
	}

}
