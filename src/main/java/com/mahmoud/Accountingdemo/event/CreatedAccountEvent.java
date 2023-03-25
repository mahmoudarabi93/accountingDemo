package com.mahmoud.Accountingdemo.event;

public class CreatedAccountEvent extends BaseEvent<String> {
	
	
	public final String currency;
	public final double accountBalance;
	
	public CreatedAccountEvent(String id, String currency, double accountBalance) {
		super(id);
		this.currency=currency;
		this.accountBalance=accountBalance;
	}

}
