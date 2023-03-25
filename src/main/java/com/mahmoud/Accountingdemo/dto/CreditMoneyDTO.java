package com.mahmoud.Accountingdemo.dto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditMoneyDTO {
	
	private String currency;
	private double CreditAmount;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getCreditAmount() {
		return CreditAmount;
	}
	public void setCreditAmount(double creditAmount) {
		CreditAmount = creditAmount;
	}
}
