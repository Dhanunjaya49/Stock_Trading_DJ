package com.STOCK_DJ.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Used for repository
	private Long id;
	private String name;
	private double balance;
	
	public User(String name,double balance)
		{
			this.name = name;
			this.balance=balance;
			
		}
}
