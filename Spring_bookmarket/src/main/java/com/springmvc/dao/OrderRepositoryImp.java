package com.springmvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.dto.Order;
@Repository
public class OrderRepositoryImp implements OrderRepository {
	private Map<Long,Order> listOfOrders;
	private long nextOrderId;
	
	public  OrderRepositoryImp() {
		listOfOrders =new HashMap<Long, Order>();
		nextOrderId=2000;
	}



	


	@Override
	public Long saveOrder(Order order) {
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}
	
	private long getNextOrderId() {
		return nextOrderId++;
	}


}
