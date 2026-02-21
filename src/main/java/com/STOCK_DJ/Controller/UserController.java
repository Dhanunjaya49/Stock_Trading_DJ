package com.STOCK_DJ.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.STOCK_DJ.model.User;
import com.STOCK_DJ.service.Userservice;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	private final Userservice userservice;
	
	public UserController(Userservice userservice)
	{
		this.userservice = userservice;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return userservice.CreateUser(user.getName(),user.getBalance());
	}
	
	@GetMapping
	public List<User> findall()
	{
		return userservice.getall();
	}
	
	
	

}
