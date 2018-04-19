package com.mercury.SpringBootRestDemo.bean;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.JoinColumn;
@Entity
@Table(name="msi_user")
public class User implements UserDetails{
	@Id
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	//configure many to many relationship
	@ManyToMany(fetch=FetchType.EAGER)//DEFATLT IS LAZY
	@JoinTable(name="msi_user_msi_user_profile",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="user_profile_id", referencedColumnName = "id")})
	private List<UserProfile> profiles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, List<UserProfile> profiles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profiles = profiles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<UserProfile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profiles=" + profiles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return profiles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-genesrated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
