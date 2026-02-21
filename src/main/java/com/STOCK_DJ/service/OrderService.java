package com.STOCK_DJ.service;

import org.springframework.stereotype.Service;

import com.STOCK_DJ.Repository.OrderRepository;
import com.STOCK_DJ.Repository.StockRepository;
import com.STOCK_DJ.Repository.UserRepository;
import com.STOCK_DJ.model.*;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private final OrderRepository orderrepository;
	private final UserRepository userrepository;
	private final StockRepository stockrepository;
	
	public OrderService(OrderRepository orderrepository,UserRepository userrepository,StockRepository stockrepository)
	{
		this.orderrepository = orderrepository;
		this.userrepository = userrepository;
		this.stockrepository = stockrepository;
	}
	
	@Transactional
	public Order BuyStock(int quantity,Long userid,String symbol)
	{
		if(quantity<=0)
		{
			throw new IllegalArgumentException("Stock over");
		}
		
		User user = userrepository.findById(userid).orElseThrow(() -> new IllegalArgumentException("User not found"));
		Stock stock = stockrepository.findBySymbol(symbol).orElseThrow(() -> new IllegalArgumentException("Stock not found"));
		
		double totalprice = quantity* stock.getPrice();
		
		
		
		if(user.getBalance()<totalprice)
		{
			throw new IllegalArgumentException("NO BALANCE TO BUY");
		}
		
		user.setBalance(user.getBalance() - totalprice);
		Order order = new Order(user,stock,quantity,stock.getPrice(),totalprice);
		
		return orderrepository.save(order);
	}
}

