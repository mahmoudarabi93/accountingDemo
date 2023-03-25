package com.mahmoud.Accountingdemo.aggregate_entity;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
//import org.axonframework.modelling.command.AggregateRoot;
import org.axonframework.spring.stereotype.Aggregate;

import com.mahmoud.Accountingdemo.command.CreateAccountCommand;
import com.mahmoud.Accountingdemo.command.CreditMoneyCommand;
import com.mahmoud.Accountingdemo.command.DepitMoneyCommand;
import com.mahmoud.Accountingdemo.entity.Status;
import com.mahmoud.Accountingdemo.event.AccountHeldEvent;
import com.mahmoud.Accountingdemo.event.ActivatedAccountEvent;
import com.mahmoud.Accountingdemo.event.CreatedAccountEvent;
import com.mahmoud.Accountingdemo.event.CreditedMoneyEvent;
import com.mahmoud.Accountingdemo.event.DepitedMoneyEvent;



@Aggregate
public class AccountAggregate {
@AggregateIdentifier
private String id;
private String status;
private String currency;
private double accountBalance;


public AccountAggregate(){
	
}
@CommandHandler
public AccountAggregate(CreateAccountCommand createAccountCommand) {
	AggregateLifecycle.apply(new CreatedAccountEvent(createAccountCommand.id,createAccountCommand.currency,createAccountCommand.accountBalnace));
}


@EventSourcingHandler
protected void on(CreatedAccountEvent createdAccountEvent) {
	
	this.id=createdAccountEvent.id;
	this.accountBalance=createdAccountEvent.accountBalance;
	this.currency= createdAccountEvent.currency;
	this.status= String.valueOf(Status.CREATED);
	
	AggregateLifecycle.apply(new ActivatedAccountEvent(this.id,Status.ACTIVATED));
}

@EventSourcingHandler
protected void on(ActivatedAccountEvent activatedAccountEvent) {
	this.status=String.valueOf(activatedAccountEvent.status) ;
}

@CommandHandler
protected void on(CreditMoneyCommand creditMoneyCommand) {
	
	AggregateLifecycle.apply(new CreditedMoneyEvent(creditMoneyCommand.id,creditMoneyCommand.currency,creditMoneyCommand.creditAmount));
	
}

@EventSourcingHandler
protected void on(CreditedMoneyEvent creditedMoneyEvent) {
	if(this.accountBalance<0 && (creditedMoneyEvent.creditAmount+this.accountBalance>=0)) {
		AggregateLifecycle.apply(new ActivatedAccountEvent(this.id,Status.ACTIVATED));
		
		this.accountBalance += creditedMoneyEvent.creditAmount;
	}
}

@CommandHandler
protected void on(DepitMoneyCommand depitMoneyCommand) {
	AggregateLifecycle.apply(new DepitedMoneyEvent(depitMoneyCommand.id,depitMoneyCommand.currency,depitMoneyCommand.depitAmount));
}

@EventSourcingHandler
protected void on(DepitedMoneyEvent depitedMoneyEvent) {
	if(this.accountBalance>0 & (this.accountBalance-depitedMoneyEvent.depitAmount<0)) {
		AggregateLifecycle.apply(new AccountHeldEvent(this.id,Status.HOLD));
		
		this.accountBalance -=  depitedMoneyEvent.depitAmount;
	}
}

@EventSourcingHandler
protected void on (AccountHeldEvent accountHeldEvent) {
	this.status = String.valueOf(accountHeldEvent.status);
}

}
