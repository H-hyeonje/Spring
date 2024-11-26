package com.springmvc.service;

import com.springmvc.dto.Order;

public interface OrderService {
	void confirmOrder(String bookId,long quantity);
	Long saveOrder(Order order);
}
