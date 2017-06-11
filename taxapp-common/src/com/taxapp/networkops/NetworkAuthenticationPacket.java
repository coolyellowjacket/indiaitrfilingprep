package com.taxapp.networkops;

public class NetworkAuthenticationPacket {
	public String getUsername() {
		return username;
	}
@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
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

	String username;
	String password;
	
	public NetworkAuthenticationPacket(String username, String password){
		this.username = username;
		this.password = password;
	}
}
