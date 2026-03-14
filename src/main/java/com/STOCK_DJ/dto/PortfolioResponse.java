package com.STOCK_DJ.dto;

import java.util.List;

public class PortfolioResponse {
	
	private String name;
	private List<StockHoldingdto> portfolio;
	
	public PortfolioResponse(String name,List<StockHoldingdto> portfolio)
	{
		this.name = name;
		this.portfolio = portfolio;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<StockHoldingdto> getPortfolio()
	{
		return portfolio;
	}
}
