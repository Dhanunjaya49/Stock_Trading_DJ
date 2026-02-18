package com.STOCK_DJ.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Used for repository only
	private Long id;
	private String name;
	private double balance;
	
	public User()
	{
	}
		
	public User(String name,double balance)
		{
			this.name = name;
			this.balance=balance;
			
		}
	
	
	
	
	
	
	

}
