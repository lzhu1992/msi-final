package com.mercury.SpringBootRestDemo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_transaction")
public class Transaction {
      @Id
      private int id;
      @Column
      private int account;
      @Column
      private String tdate;
      @Column 
      private String recipient;
      @Column 
      private int amount;
      @Column
      private  int deposit;
      @Column
      private  String describe;
	public Transaction(  int id, int account, String tdate, String recipient, int amount, int deposit, String describe) {
		super();
		this.id = id;
		this.account = account;
		this.tdate = tdate;
		this.recipient = recipient;
		this.amount = amount;
		this.deposit = deposit;
		this.describe = describe;
	}
	public Transaction() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
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
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account=" + account + ", tdate=" + tdate + ", recipient=" + recipient
				+ ", amount=" + amount + ", deposit=" + deposit + ", describe=" + describe + "]";
	}
	
      
    
      
      
      
      
      
}
