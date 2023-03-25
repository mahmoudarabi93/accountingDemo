package com.mahmoud.Accountingdemo.command;

public class CreditMoneyCommand extends BaseCommand<String> {
	
	public final String currency;
	public final double creditAmount;
	
	public CreditMoneyCommand(String id,String currency, double creditAmount) {
		super(id);
		this.currency=currency;
		this.creditAmount=creditAmount;
		
	}
	
	
	

}
