package com.taxapp.datapackets;

public class Address {
	String nickName;
	String house;
	String road;
	String area;
	String city;
	String state;
	int pincode;
	int isMetro;
	String mobileNumber;
	String landLineNumber;
	String stdCode;

	
	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public String getRoad() {
		return road;
	}


	public void setRoad(String road) {
		this.road = road;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public int getIsMetro() {
		return isMetro;
	}


	public void setIsMetro(int isMetro) {
		this.isMetro = isMetro;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getLandLineNumber() {
		return landLineNumber;
	}


	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}


	public String getStdCode() {
		return stdCode;
	}


	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	
	public Address(){
		
	}
}
