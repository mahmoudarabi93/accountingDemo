package com.mahmoud.Accountingdemo.service;

import java.util.concurrent.CompletableFuture;

import com.mahmoud.Accountingdemo.dto.CreateAccountDTO;
import com.mahmoud.Accountingdemo.dto.CreditMoneyDTO;
import com.mahmoud.Accountingdemo.dto.DepitMoneyDTO;

public interface AccountCommandService {
	
	CompletableFuture<String> CreateAccount(CreateAccountDTO createAccountDTO);
	CompletableFuture<String> DepitMoney(String accountNumber,DepitMoneyDTO depitMoneyDTO);
	CompletableFuture<String> CreditMoney(String accountNumber,CreditMoneyDTO creditMoneyDTO);

}
