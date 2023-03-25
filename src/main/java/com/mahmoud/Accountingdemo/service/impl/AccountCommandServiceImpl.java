package com.mahmoud.Accountingdemo.service.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.mahmoud.Accountingdemo.command.CreateAccountCommand;
import com.mahmoud.Accountingdemo.command.CreditMoneyCommand;
import com.mahmoud.Accountingdemo.command.DepitMoneyCommand;
import com.mahmoud.Accountingdemo.dto.CreateAccountDTO;
import com.mahmoud.Accountingdemo.dto.CreditMoneyDTO;
import com.mahmoud.Accountingdemo.dto.DepitMoneyDTO;
import com.mahmoud.Accountingdemo.service.AccountCommandService;


@Service
public class AccountCommandServiceImpl implements AccountCommandService {
	
	private final CommandGateway commandGateway;
	
	

	public AccountCommandServiceImpl(CommandGateway commandGateway) {
		
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> CreateAccount(CreateAccountDTO createAccountDTO) {
		// TODO Auto-generated method stub
		return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),createAccountDTO.getCurrency(),createAccountDTO.getStarterBalance()) );
	}

	@Override
	public CompletableFuture<String> DepitMoney(String accountNumber,DepitMoneyDTO depitMoneyDTO) {
		// TODO Auto-generated method stub
		return commandGateway.send(new DepitMoneyCommand(accountNumber,depitMoneyDTO.getCurrency(),depitMoneyDTO.getDepitAmount()));
	}

	@Override
	public CompletableFuture<String> CreditMoney(String accountNumber,CreditMoneyDTO creditMoneyDTO) {
		// TODO Auto-generated method stub
		return commandGateway.send(new CreditMoneyCommand(accountNumber,creditMoneyDTO.getCurrency(),creditMoneyDTO.getCreditAmount())) ;
	}

}
