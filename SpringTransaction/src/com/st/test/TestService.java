package com.st.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.st.entity.LineItem;
import com.st.entity.Order;
import com.st.entity.Payment;
import com.st.service.ShoppingService;

public class TestService {
	
	@Test
	public void test(){
		
		ApplicationContext container = new ClassPathXmlApplicationContext("configSpringTransaction.xml");
		ShoppingService shoppingservice = (ShoppingService) container.getBean("shoppingServ");
		
		Order order = new Order();
		order.setId(123);
		order.setAmount(549.5);
		
		LineItem l1 = new LineItem();
		l1.setId(1);
		l1.setQuantity(4);
		
		LineItem l2 = new LineItem();
		l2.setId(2);
		l2.setQuantity(8);

		LineItem l3 = new LineItem();
		l3.setId(3);
		l3.setQuantity(44);
		
		List<LineItem> lineItems = new ArrayList<>();
		lineItems.add(l1);
		lineItems.add(l2);
		lineItems.add(l3);
		order.setItems(lineItems);
		
		Payment payment = new Payment();
		payment.setId(111);
		payment.setMode("ATM");
		payment.setAmount(order.getAmount());
		order.setPayment(payment);

		shoppingservice.placeOrder(order);	
	} 
}
