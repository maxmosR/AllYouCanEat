package com.portafoglio.allyoucaneat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.portafoglio.allyoucaneat.model")
@EnableJpaRepositories(basePackages = "com.portafoglio.allyoucaneat.repository")
public class AllyoucaneatApplication {
	public static void main(String[] args) {
		SpringApplication.run(AllyoucaneatApplication.class, args);
	}
}
