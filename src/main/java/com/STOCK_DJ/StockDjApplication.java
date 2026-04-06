package com.STOCK_DJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class StockDjApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDjApplication.class, args);
	}

}
