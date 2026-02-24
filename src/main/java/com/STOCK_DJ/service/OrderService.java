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
		
		double totalprice = quantity * stock.getPrice();
		
		
		
		if(user.getBalance()<totalprice)
		{
			throw new IllegalArgumentException("NO BALANCE TO BUY");
		}
		
		user.setBalance(user.getBalance() - totalprice);
		Order order = new Order(user,stock,quantity,stock.getPrice(),totalprice,OrderType.BUY);
		
		return orderrepository.save(order);
	}
	
	@Transactional
	public Order SellStock(Long userid,String symbol,int quantity)
	{
		if(quantity<=0)
		{
			throw new IllegalArgumentException("No Stocks Left");
		}
		
		User user = userrepository.findById(userid).orElseThrow(() -> new IllegalArgumentException("user does not exist"));
		
		Stock stock = stockrepository.findBySymbol(symbol).orElseThrow(() -> new IllegalArgumentException("stock does not exist"));
		
		int ownedShares = orderrepository.findByUserId(userid).stream()
		        .filter(o -> o.getStock().getSymbol().equalsIgnoreCase(symbol))
		        .mapToInt(o -> o.getType() == OrderType.BUY
		                ? o.getQuantity()
		                : -o.getQuantity()).sum();
	
		System.out.println("owned shares"+ownedShares);
		if(ownedShares < quantity)
		{
			throw new IllegalArgumentException("Not enough shares to sell");
		}
		
		double totprice = stock.getPrice() * quantity;
		
		user.setBalance(user.getBalance() + totprice);
		
		Order order = new Order(user,stock,quantity,stock.getPrice(),totprice,OrderType.SELL);
		
		return orderrepository.save(order);
	}
}

