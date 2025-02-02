package com.training.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.CarPartsInventory;
import com.training.entity.CarParts;

public class TestCarParts {
	
	@Test
	public void test() {
		ApplicationContext container = new ClassPathXmlApplicationContext("configJdbc.xml");
		CarPartsInventory carPartsInventory = (CarPartsInventory) container.getBean("carPartsInv");
		//Assert.assertNotNull(carPart);
		
//		CarParts part = new CarParts();
//		part.setPartNo(321);
//		part.setPartName("Mirror");
//		part.setQuantity(250);
//		
//		carPartsInventory.addNewPart(part);
//		
		CarParts part = carPartsInventory.loadCarParts(321);
		System.out.println(part.getPartNo() + " , "+ part.getPartName()+ " , "+ part.getQuantity());
		
	}
}
