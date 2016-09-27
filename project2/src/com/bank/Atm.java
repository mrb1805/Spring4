package com.bank;

public class Atm {
	
	private Bank bank;
	
	public void setBank(Bank bank){
		this.bank = bank;
	}
	
	public void withdraw(double amount){
		bank.withdrawMoney(amount);
	}
		
}
