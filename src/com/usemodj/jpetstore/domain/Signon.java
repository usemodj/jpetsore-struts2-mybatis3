package com.usemodj.jpetstore.domain;

import java.io.Serializable;

public class Signon implements Serializable {
	private String username;
	private String password;
	private String passwordConfirm;
	private String passwordNew;
	private String role;
	
	public Signon(String username, String password){
		this.username = username;
		this.password = password;
	}
	public Signon() {
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
