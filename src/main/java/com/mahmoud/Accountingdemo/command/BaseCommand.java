package com.mahmoud.Accountingdemo.command;

public class BaseCommand<T>{

	public final T id;
	
	public BaseCommand(T id) {
		this.id = id;
	}
	
	
	
}
