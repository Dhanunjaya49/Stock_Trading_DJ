package com.STOCK_DJ.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.STOCK_DJ.Repository.OrderRepository;
import com.STOCK_DJ.Repository.UserRepository;
import com.STOCK_DJ.model.User;



@Service
public class Userservice {
	
	private final UserRepository userrepository;
	private final OrderRepository orderrepository;
	
	public  Userservice(UserRepository userrepository,OrderRepository orderrepository)
	{
		this.userrepository = userrepository;
		this.orderrepository = orderrepository;
	}
	
	public User CreateUser(String name,double balance)
	{
		if(balance<0.0)
		{
			throw new IllegalArgumentException("Balance cant be less than 0");
		}
		User user = new User(null,name,balance);
	     return	userrepository.save(user);
	}
	public List<User> getall()
	{
		return userrepository.findAll();
	}
	
	public void DeleteUser(Long id)
	{
		if(orderrepository.existsByUserId(id)) {
		    throw new RuntimeException("User has orders, cannot delete");
		}
		 userrepository.deleteById(id);
	}
}
