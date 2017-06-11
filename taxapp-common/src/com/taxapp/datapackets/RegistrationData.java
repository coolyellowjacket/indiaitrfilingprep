package com.taxapp.datapackets;

//1. On registration check to see if the email id, username, and mobile number are unique
//2. send confirmation to the mobile number/email address
//3. they have to enter the confirmation code or click on the link to complete registation
public class RegistrationData {
	String username;				//Cannot be null, must be alphanumeric, no spaced and less than 10 chars
	String password;				//Cannot be null, must be alphanumeric with 1 small letter, 1 number, 1 caps letter, 1 special character, no space
	String firstName;				//Cannot be null, must be alphabetical, no spaces.
	String lastName;				//Cannot be null, must be alphabetical, no spaces.
	String mobileNumber;			//Cannot be null, must be numeric, no spaces.
	String emailAddress;			//Cannot be null, must be in format of a <alphanumeric>@<web address format>

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public RegistrationData(){
		//Offshore: create constructors as needed	
	}
}
