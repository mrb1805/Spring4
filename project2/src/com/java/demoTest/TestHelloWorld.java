package com.java.demoTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.demo.HelloWorldInterface;

public class TestHelloWorld {
	
	@Test
	public void test(){
		 //read XML and start creating bean
		ApplicationContext container = new ClassPathXmlApplicationContext("demoConfig.xml");
		// Get the bean 
		HelloWorldInterface hw = (HelloWorldInterface) container.getBean("hw");
		System.out.println(hw.sayHello("Mahesh"));
		
	}

}
