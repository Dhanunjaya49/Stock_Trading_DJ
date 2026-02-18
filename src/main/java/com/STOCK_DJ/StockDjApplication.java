package com.STOCK_DJ;
import com.STOCK_DJ.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.STOCK_DJ.Repository.UserRepository;

@SpringBootApplication
public class StockDjApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDjApplication.class, args);
	}
	
	

}
