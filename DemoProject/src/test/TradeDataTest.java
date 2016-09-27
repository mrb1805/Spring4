package test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.TradeApp;
import main.TradeData;



//Use the same test class for testing different behavior by just changing the name of the xml file
public class TradeDataTest {

	@Test
	public void testTradeData() {
		ApplicationContext container = new ClassPathXmlApplicationContext("xml-config-1.xml");
		TradeData tradeDao = (TradeData) container.getBean("tradeDataNY");
		Assert.assertNotNull(tradeDao);
		System.out.println(tradeDao);
		TradeApp data = new TradeApp();
		System.out.println(data.toString());
		
//		Assert.assertNotNull(tradeDao);
//		tradeDao.setTradeId("NY123");
//		TradeData data = new DaoNewYork();
//		data.getTradeDetails("NY123");
		
		
		
	}
}
