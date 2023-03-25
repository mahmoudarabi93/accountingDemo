package com.mahmoud.Accountingdemo.event;

public class DepitedMoneyEvent extends BaseEvent<String> {
	
	
	
	public final String currency;
	public final double depitAmount;
	
	public DepitedMoneyEvent(String id , String currency,double depitAmount){
		super(id);
		this.currency=currency;
		this.depitAmount=depitAmount;
	}
	
	

}
