package com.springmvc.dao;

import com.springmvc.dto.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
}
