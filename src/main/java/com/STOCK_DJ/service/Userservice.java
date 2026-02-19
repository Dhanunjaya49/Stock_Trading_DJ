package com.STOCK_DJ.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.STOCK_DJ.Repository.UserRepository;
import com.STOCK_DJ.model.User;



@Service
public class Userservice {
	
	private final UserRepository userrepository;
	
	public  Userservice(UserRepository userrepository)
	{
		this.userrepository = userrepository;
	}
	
	public User CreateUser(String name,double balance)
	{
		
		if(balance<0.0)
		{
			throw new IllegalArgumentException("Balance cant be less than 0");
		}
		User user = new User(name,balance);
	     return	userrepository.save(user);
	}
	
	public List<User> getall()
	{
		return userrepository.findAll();
	}

}
