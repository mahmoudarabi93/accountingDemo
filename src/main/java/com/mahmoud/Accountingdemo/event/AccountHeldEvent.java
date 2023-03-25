package com.mahmoud.Accountingdemo.event;

import com.mahmoud.Accountingdemo.entity.Status;

public class AccountHeldEvent  extends BaseEvent<String>{
	
	public final Status status;
	
	public AccountHeldEvent(String id,Status status) {
		super(id);
		this.status=status;
		
	}

}
