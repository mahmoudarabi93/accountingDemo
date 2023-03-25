package com.mahmoud.Accountingdemo.event;

import com.mahmoud.Accountingdemo.entity.Status;

public class ActivatedAccountEvent extends BaseEvent<String>{
	
	public final Status status;
	
	public ActivatedAccountEvent(String id, Status status) {
		super(id);
		this.status=status;
	}

}
