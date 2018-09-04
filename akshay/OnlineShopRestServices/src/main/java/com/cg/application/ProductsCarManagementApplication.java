package com.cg.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.cg.bean")
@EnableJpaRepositories("com.cg.dao")
@SpringBootApplication
@ComponentScan("com.cg")
public class ProductsCarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsCarManagementApplication.class, args);
	}
}
