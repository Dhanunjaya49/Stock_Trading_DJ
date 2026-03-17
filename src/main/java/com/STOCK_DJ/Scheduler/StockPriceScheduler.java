package com.STOCK_DJ.Scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.STOCK_DJ.Repository.StockRepository;
import com.STOCK_DJ.model.Stock;

@Component
public class StockPriceScheduler 
{	
	
	private final StockRepository stockrepository;
	
	public StockPriceScheduler(StockRepository stockrepository)
	{
		this.stockrepository=stockrepository;
	}
		
	@Scheduled(fixedRate = 60000)
	public void UpdateStockPrices()
	{
		System.out.println("Running and Updating  " + LocalDateTime.now());
		
		List<Stock> stocks = stockrepository.findAll();
		for(Stock s : stocks)
		{
		System.out.println(s.getName() +" is valued at "+s.getPrice()+" currently ");
	}
}
}

