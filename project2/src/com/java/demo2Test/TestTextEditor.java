package com.java.demo2Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.demo2.TextEditor;

public class TestTextEditor {
	
	@Test
	public void test(){
		 //read XML and start creating bean
		ApplicationContext container = new ClassPathXmlApplicationContext("demoConfig.xml");
		// Get the bean 
		TextEditor calc = (TextEditor) container.getBean("bank");
		calc.load("mahesh");
		
	}

}
