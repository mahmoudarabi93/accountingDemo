package com.mahmoud.Accountingdemo.event;

public class CreditedMoneyEvent extends BaseEvent<String> { 
	
	
	public final String currency;
	public final double creditAmount;
	
public	CreditedMoneyEvent(String id, String currency, double creditAmount){
		super(id);
		this.currency=currency;
		this.creditAmount=creditAmount;
		
	}

}
