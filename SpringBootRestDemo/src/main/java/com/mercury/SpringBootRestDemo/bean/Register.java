package com.mercury.SpringBootRestDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_user")
public class Register {
	
     @Id
	 private String email;
	 @Column
     private int ssn;
	 @Column
     private int account;
	 @Column
     private String type;
	 @Column
     private String password;
	public Register(String email, int ssn, int account, String type, String password) {
		super();
		this.email = email;
		this.ssn = ssn;
		this.account = account;
		this.type = type;
		this.password = password;
	}
	public Register() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", ssn=" + ssn + ", account=" + account + ", type=" + type + ", password="
				+ password + "]";
	}
	
	
	 
}
     
    
