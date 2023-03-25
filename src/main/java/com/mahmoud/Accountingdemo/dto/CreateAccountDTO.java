package com.mahmoud.Accountingdemo.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountDTO {
	
	private String currency;
	private double starterBalance;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getStarterBalance() {
		return starterBalance;
	}
	public void setStarterBalance(double starterBalance) {
		this.starterBalance = starterBalance;
	}

}
