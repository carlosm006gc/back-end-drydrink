package com.dev.drydrink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.dev.drydrink.domain")
@ComponentScan(basePackages = {"com.dev.drydrink*"})
@EnableJpaRepositories(basePackages = {"com.dev.drydrink.repository"})
@EnableTransactionManagement

public class DrydrinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrydrinkApplication.class, args);
	}
}

