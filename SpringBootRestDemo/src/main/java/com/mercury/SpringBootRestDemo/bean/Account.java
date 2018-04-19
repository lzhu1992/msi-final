package com.mercury.SpringBootRestDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class Account {  
	  @Id
     private int account;
     @Column
	  private String name;
     @Column
	  private int amount;
	 public Account( int account, String name, int amount) {
		super();
		this.account = account;
		this.name = name;
		this.amount = amount;
	 }
	 
	 public Account() {
		super();
	 }

	
	 public int getAccount() {
		return account;
	 }
	 public void setAccount(int account) {
		this.account = account;
	 }
	 public String getName() {
		return name;
	 }
	 public void setName(String name) {
	 	this.name = name;
	 }
	 public int getAmount() {
		return amount;
	 }
	 public void setAmount(int amount) {
		this.amount = amount;
	 }

	 @Override
	 public String toString() {
		return "Account [ account=" + account + ", name=" + name + ", amount=" + amount + "]";
	 }	  
	  
}
