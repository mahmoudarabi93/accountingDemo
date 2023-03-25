package com.mahmoud.Accountingdemo.dto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepitMoneyDTO {
	
	private String currency;
	private double depitAmount;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getDepitAmount() {
		return depitAmount;
	}
	public void setDepitAmount(double depitAmount) {
		this.depitAmount = depitAmount;
	}

}
