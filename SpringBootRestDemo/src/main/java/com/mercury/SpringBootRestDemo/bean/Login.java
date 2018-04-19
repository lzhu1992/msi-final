package com.mercury.SpringBootRestDemo.bean;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

public class Login {
	@Id
     private String email;
	@Column
     private String password;
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public Login() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	
}
