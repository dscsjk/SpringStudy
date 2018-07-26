package com.wind.web.dto;

public class TicketDto {
	
	private String ConsumerId;
	private int Amount;
	
	public TicketDto() {};
	
	public TicketDto(String ConsumerId, int Amount) {
		super();
		this.ConsumerId = ConsumerId;
		this.Amount = Amount;
	}
	public String getConsumerId() {
		return ConsumerId;
	}

	public void setConsumerId(String consumerId) {
		ConsumerId = consumerId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
}
