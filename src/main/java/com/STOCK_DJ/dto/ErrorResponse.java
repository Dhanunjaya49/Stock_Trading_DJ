package com.STOCK_DJ.dto;

public class ErrorResponse {

	private String message;
	private int request;
	
	public ErrorResponse(String messsage,int request)
	{
		this.message = message;
		this.request = request;
	}
	
	public String getmessage()
	{
		return message;
	}
	public int getrequest()
	{
		return request;
	}
}

