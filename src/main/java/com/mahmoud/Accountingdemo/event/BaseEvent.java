package com.mahmoud.Accountingdemo.event;

import org.axonframework.modelling.command.AggregateIdentifier;

import lombok.Value;


public class BaseEvent<T> {
	
	@AggregateIdentifier
	public final T id;
	
	
	public BaseEvent(T id) {
		
		this.id=id;
		
	}

}
