package com.bank;

public class Bank {
	
	private int Balance;	
	
	public void withdrawMoney(double Amount){
		if(Amount>Balance)
		{
			System.out.println("insufficient Balance");
		}
		else
		{
			System.out.println("Collect your Money !!");
		}
			
	}
}
