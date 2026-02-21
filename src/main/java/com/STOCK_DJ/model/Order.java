package com.STOCK_DJ.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Orders")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="stock_id")
	private Stock stock;
	
	private int quantity;
	private double purchasedprice;
	private double totalamount;
	private LocalDateTime createdat;
	
	public Order(User user, Stock stock,int quantity,double purchasedprice,double totalamount)
	{
		this.user = user;
		this.stock = stock;
		this.quantity=quantity;
		this.purchasedprice = purchasedprice;
		this.totalamount = totalamount;
		this.createdat = LocalDateTime.now();
	}
	
	
	
	

}
