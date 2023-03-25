package com.mahmoud.Accountingdemo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmoud.Accountingdemo.dto.CreateAccountDTO;
import com.mahmoud.Accountingdemo.dto.CreditMoneyDTO;
import com.mahmoud.Accountingdemo.dto.DepitMoneyDTO;
import com.mahmoud.Accountingdemo.service.AccountCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/banck_account")
@Api(value="Account Commands",tags="Account Commands")
public class AccountComandController {
	
	@Autowired
	private final AccountCommandService accountCommandService;

	public AccountComandController(AccountCommandService accountCommandServic) {
		super();
		this.accountCommandService = accountCommandServic;
	}
	
	@PostMapping
	public CompletableFuture<String> createAccount(@RequestBody CreateAccountDTO createAccountDTO){
		return accountCommandService.CreateAccount(createAccountDTO);
	}
	
	
	@PutMapping("/depit/{accountNumber}")
	public CompletableFuture<String> depitMoney(@PathVariable(value="accountNumber") String accountNumber, @RequestBody DepitMoneyDTO depitMoneyDTO){
		return accountCommandService.DepitMoney(accountNumber, depitMoneyDTO);
	}
	
	@PutMapping("/credit/{accountNunmber}")
	public CompletableFuture<String> creditMoney(@PathVariable(value="accountNumber") String accountNumber, CreditMoneyDTO creditMoneyDTO){
		
		
		return accountCommandService.CreditMoney(accountNumber, creditMoneyDTO);
	}

}
