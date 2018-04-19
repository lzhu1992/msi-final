package com.mercury.SpringBootRestDemo.bean;

public class Transfer {
	  private String recipient;
	  private int amount;
	public Transfer(String recipient, int amount) {
		super();
		this.recipient = recipient;
		this.amount = amount;
	}
	public Transfer() {
		super();
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transfer [recipient=" + recipient + ", amount=" + amount + "]";
	}
}  
	  