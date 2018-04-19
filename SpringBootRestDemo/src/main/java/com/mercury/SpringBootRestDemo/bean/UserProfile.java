package com.mercury.SpringBootRestDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="msi_user_profile")
public class UserProfile implements GrantedAuthority {
	@Id
	private int id;
	@Column
	private String type;
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfile(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", type=" + type + "]";
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return type;
	}
	
}
