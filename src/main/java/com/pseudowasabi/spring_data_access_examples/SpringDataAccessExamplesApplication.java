package com.pseudowasabi.spring_data_access_examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableJdbcRepositories(basePackages = "com.pseudowasabi.spring_data_access_examples.repository.jdbc")
public class SpringDataAccessExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAccessExamplesApplication.class, args);
	}

}
