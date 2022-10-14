package com.example.CorrettoTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CorrettoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrettoTestApplication.class, args);
	}

}
