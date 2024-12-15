package com.ringoxcoffee.furniture_fix_request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FurnitureFixRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurnitureFixRequestApplication.class, args);
	}

}
