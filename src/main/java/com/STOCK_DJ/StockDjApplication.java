package com.STOCK_DJ;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.STOCK_DJ.model.User;
import com.STOCK_DJ.service.Userservice;

@SpringBootApplication
public class StockDjApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDjApplication.class, args);
	}
	
	@Bean
	CommandLineRunner test(Userservice userservice)
	{
		return args ->
		{
			userservice.CreateUser("Dhanu",10000);
			userservice.CreateUser("Indu",15000);
			
			userservice.getall().forEach(System.out::println);
		};
	}
	
	

}
