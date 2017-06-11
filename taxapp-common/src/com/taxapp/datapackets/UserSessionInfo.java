package com.taxapp.datapackets;

public class UserSessionInfo {
	int userId;				//User Id from usermaster
	String username;
	int ITRId;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getITRId() {
		return ITRId;
	}
	public void setITRId(int iTRId) {
		ITRId = iTRId;
	}
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	
}
