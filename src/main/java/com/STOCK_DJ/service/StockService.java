package com.STOCK_DJ.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.STOCK_DJ.Repository.StockRepository;
import com.STOCK_DJ.model.Stock;

import jakarta.transaction.Transactional;

@Service
public class StockService {

	
	private final StockRepository stockrepository;
	
	public StockService(StockRepository stockrepository)
	{
		this.stockrepository = stockrepository;

	}
	
	public Stock createStock(String symbol,String name,double price)
	{
		if(price<=0)
		{
			throw new IllegalArgumentException("valid price please");
		}
		if(stockrepository.existsBySymbol(symbol))
		{
			throw new IllegalArgumentException("Stock already exists");
		}
		
		Stock stock = new Stock(null,symbol,name,price);
		return stockrepository.save(stock);
	}
	
	public List<Stock> getall()
	{
		return stockrepository.findAll();
	}
	
	
	public Stock getbySymbol(String symbol)
	{
		return stockrepository.findBySymbol(symbol).orElseThrow(() -> new IllegalArgumentException("No stock exits"));
	}
	
	@Transactional
	public void updatePrice(String symbol,double newprice)
	{
		Stock stock = getbySymbol(symbol);
		
		if(newprice<=0)
		{
			throw new IllegalArgumentException("Invalid Price");
		}
		stock.setPrice(newprice);
		stockrepository.save(stock);
	}
	
	

}
