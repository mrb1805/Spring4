package ex1;

import org.springframework.beans.factory.annotation.Value;

public class ErrorHandler2 {

	//TODO 2: initialize the defaultLocale field with the system locale using EL.
	//Refer to slide no. 78 for details.
	private String defaultLocale;
	
	public void handleError() {
		//some error handling here which is locale specific
		System.out.println(defaultLocale);
	}
}
