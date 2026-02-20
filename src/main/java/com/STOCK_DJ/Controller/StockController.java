package com.STOCK_DJ.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.STOCK_DJ.model.Stock;
import com.STOCK_DJ.service.StockService;

@RestController
@RequestMapping("/Stocks")
public class StockController {

	private final StockService stockservice;
	
	public StockController(StockService stockservice)
	{
		this.stockservice = stockservice;
	}
	
	@PostMapping
	public Stock CreateStock(@RequestBody Stock stock)
	{
		return stockservice.createStock(stock.getSymbol(),stock.getName(),stock.getPrice());
		
	}
	
	@GetMapping
	public List<Stock> GetallStocks()
	{
		return stockservice.getall();
	}
	
	@GetMapping("/{symbol}")
	public Stock getbysymbol(@PathVariable String symbol)
	{
		return stockservice.getbySymbol(symbol);
		
	}
	
	
	
	
}
