package com.STOCK_DJ.dto;

public class StockHoldingdto {
	
	private String symbol;
	private int shares;
	
	public StockHoldingdto(String symbol,int shares)
	{
		this.symbol = symbol;
		this.shares = shares;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	public int getShares()
	{
		return shares;
	}

}
