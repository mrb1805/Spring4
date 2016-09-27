package com.jpmc.demoTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpmc.demo.HelloWorld;

public class TestHelloWorld {
	
	@Test
	public void test(){
		 //read XML and start creating bean
		ApplicationContext container = new ClassPathXmlApplicationContext("demoConfig.xml");
		// Get the bean 
		HelloWorld hw = (HelloWorld) container.getBean("hw");
		System.out.println(hw.sayHello("Mahesh"));
		
	}

}
