package com.wellsfaro.fsd.sba2.coronakit.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;


@Entity
@Table(name = "users")
public class Users {

	
	@Id
	@Column(name="unm",unique=true)
	private String username;

	@Transient
	private String password;
	
	@Column(name="pwd")
	private String encodedPassword;
	
	@Column
	private boolean enabled;
	
	@Column
	private String email;
	
	@Column
	private String contact;
	
	@Column
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEncodedPassword() {
		return encodedPassword;
	}
	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}
	public Users(String username, String password, String encodedPassword, boolean enabled, String email, String contact, String role) {
		super();
		this.username = username;
		this.password = password;
		this.encodedPassword=encodedPassword;
		this.enabled = enabled;
		this.email = email;
		this.contact = contact;
		this.role = role;
	}
	public Users() {
		super();
	}
	
	
}
