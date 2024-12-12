package com.plataform.orderapi.order_e_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class OrderECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderECommerceApplication.class, args);
	}

}
