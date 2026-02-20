package com.STOCK_DJ.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name="stocks")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private  Long id;
	
	@Column(unique=true,nullable = false)
	private String symbol;
	
	@Column(unique=true,nullable = false)
	private String name;
	
	@Column(unique=true,nullable = false)
	private double price;

	public Stock(String symbol,String name,double price)
	{
		this.symbol = symbol;
		this.name = name;
		this.price = price;
	}
}
