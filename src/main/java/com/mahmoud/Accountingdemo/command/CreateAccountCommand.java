package com.mahmoud.Accountingdemo.command;

public class CreateAccountCommand extends BaseCommand<String> {

	public final String currency;
	
	public final double accountBalnace;
	
	
	public CreateAccountCommand(String id, String currency,double AccountBalance) {
		
		super(id);
		this.accountBalnace=AccountBalance;
		this.currency=currency;
		
	}
	
	
}
