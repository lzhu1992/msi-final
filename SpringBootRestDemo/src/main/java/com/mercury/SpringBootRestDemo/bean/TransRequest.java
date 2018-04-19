package com.mercury.SpringBootRestDemo.bean;

public class TransRequest {

	Transfer transfer;
	Login login;
	public TransRequest(Transfer transfer, Login login) {
		super();
		this.transfer = transfer;
		this.login = login;
	}
	public TransRequest() {
		super();
	}
	public Transfer getTransfer() {
		return transfer;
	}
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
}
