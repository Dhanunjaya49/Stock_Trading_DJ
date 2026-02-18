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
	
	@Bean 
	CommandLineRunner run(UserRepository userrepository)
	{
	
	return args -> {
		
		if(userrepository.count()==0)
		{
		
		User u1 = new User ("DJ",10000);
		User u2 = new User ("Indu",10000);
		
		userrepository.save(u1);
		userrepository.save(u2);
		
		
		}
		
	};
	}
	

}
