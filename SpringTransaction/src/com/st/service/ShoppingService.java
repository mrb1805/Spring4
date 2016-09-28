package com.st.service;

import com.st.entity.Order;

public interface ShoppingService {
	
	public void placeOrder(Order order);
	public void cancelOrder(Order order);
	public Order fetchOrder(Order order);

}
