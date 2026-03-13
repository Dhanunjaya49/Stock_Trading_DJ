package com.STOCK_DJ.dto;

import java.util.Map;

public class PortfolioResponse {
	
	private String name;
	private Map<String,Integer> portfolio;
	
	public PortfolioResponse(String name,Map<String,Integer> portfolio)
	{
		this.name = name;
		this.portfolio = portfolio;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Map<String,Integer> getPortfolio()
	{
		return portfolio;
	}
	
	

}
