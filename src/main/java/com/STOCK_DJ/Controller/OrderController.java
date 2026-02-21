package com.STOCK_DJ.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.STOCK_DJ.model.Order;
import com.STOCK_DJ.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderservice;
	
	public OrderController(OrderService orderservice)
	{
		this.orderservice = orderservice;
	}
	
	@PostMapping
	public Order buyStock(@RequestParam Long Userid,@RequestParam String symbol,@RequestParam int quantity)
	{
		return orderservice.BuyStock(quantity, Userid, symbol);
	}

}
