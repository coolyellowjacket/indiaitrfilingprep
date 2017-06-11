package com.taxapp.datapackets;

public class LoginData{
	
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

	public LoginData(){

	}
	
	String username;
	String password;
}
