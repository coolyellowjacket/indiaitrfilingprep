package com.taxapp.utils;

import java.util.Date;

public class UpdateDetails {
	Date lastUpdateDateTime; 	//when was the data in this object last updated. Must use ddMMyyyyHHmmss in IST				
	String lastUpdateIP;		//where was the last update made from					
	String lastUpdateDevice;	//which device was the last update made					
	int totalUpdates;			//Total updates		
	String className;
	int dbRecNum;
	
	public Date getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
	public void setLastUpdateDateTime(Date lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}
	public String getLastUpdateIP() {
		return lastUpdateIP;
	}
	public void setLastUpdateIP(String lastUpdateIP) {
		this.lastUpdateIP = lastUpdateIP;
	}
	public String getLastUpdateDevice() {
		return lastUpdateDevice;
	}
	public void setLastUpdateDevice(String lastUpdateDevice) {
		this.lastUpdateDevice = lastUpdateDevice;
	}
	public int getTotalUpdates() {
		return totalUpdates;
	}
	public void setTotalUpdates(int totalUpdates) {
		this.totalUpdates = totalUpdates;
	}
	public UpdateDetails(String className){
		this.className = className;
	}
}
