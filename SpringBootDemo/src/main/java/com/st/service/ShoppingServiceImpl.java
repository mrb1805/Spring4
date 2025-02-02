package com.st.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.entity.LineItem;
import com.st.entity.Order;
import com.st.entity.Payment;

//@Component("shoppingServ")
@Service("shoppingServ")
public class ShoppingServiceImpl implements ShoppingService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public void placeOrder(Order order) {
		//insert in orders table
		jdbcTemplate.update("insert into tbl_orders values(?,?)",order.getId(),order.getAmount());
		
		//insert in line items table
		for(LineItem li : order.getItems())
			jdbcTemplate.update("insert into tbl_lineitems values(?,?,?)",li.getId(),li.getQuantity(),order.getId());
		
		//insert in payment tables
		Payment payment = order.getPayment();
		jdbcTemplate.update("insert into tbl_payments values(?,?,?,?)",payment.getId(),payment.getMode(),payment.getAmount(),order.getId());
		
	}

	@Override
	public void cancelOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order fetchOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}


