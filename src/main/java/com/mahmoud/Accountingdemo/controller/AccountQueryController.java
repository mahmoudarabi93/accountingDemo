package com.mahmoud.Accountingdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmoud.Accountingdemo.service.AccountQueryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/bank_account")
@Api(value="Account Queries",tags="Account Queries")
public class AccountQueryController {
	
private final AccountQueryService accountQueryService;

public AccountQueryController(AccountQueryService accountQueryService) {
	super();
	this.accountQueryService = accountQueryService;
}



		@GetMapping("/{accountNumber}/events")
		public List<Object> listEventsForAccount(@PathVariable(value="accountNumber") String AccountNumber){
			
			return accountQueryService.listEventsforAccount(AccountNumber);
			
		}
}
