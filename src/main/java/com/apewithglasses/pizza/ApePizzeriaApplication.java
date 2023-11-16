package com.apewithglasses.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApePizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApePizzeriaApplication.class, args);
	}

}
