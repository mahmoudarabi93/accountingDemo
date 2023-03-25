package com.mahmoud.Accountingdemo.command;

public class DepitMoneyCommand extends BaseCommand<String> {

	
	public final String currency;
	public final double depitAmount;
	
	public DepitMoneyCommand(String id,String currency,double depitAmount) {
		
		
		super(id);
		this.currency=currency;
		this.depitAmount=depitAmount;
	}
}
