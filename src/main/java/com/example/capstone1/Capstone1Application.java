package com.example.capstone1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Capstone1Application {

	public static void main(String[] args) {
		SpringApplication.run(Capstone1Application.class, args);
	}

}
