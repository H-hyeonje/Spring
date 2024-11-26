package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springmvc.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class OrderContorller {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/ISBN1234/2")
	public String process() {
		orderService.confirmOrder("ISBN1234",2);
		return "redirect:/books";
	}
	
}
