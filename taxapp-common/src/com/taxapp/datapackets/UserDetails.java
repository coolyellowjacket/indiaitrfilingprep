package com.taxapp.datapackets;

import java.util.Date;

import com.taxapp.enums.Gender;
import com.taxapp.utils.UpdateDetails;

//1. When a user enters an incorrect password more than 5 times his account should be locked for 24 hrs 
//& an email and sms should be sent to him stating this
//2. On selecting forgot password an email should be sent allowing him to reset the password
//3. When trying to change the password we should ask for old password and validate
//4. Details on when password was chnaged etc should be stored

public class UserDetails {
	
	//Following copied only once after successful registration
	//Mobile number only copied once from upon successful registration. Remaining address fields taken later.
	private String username;				//It can only be set once during registration		
	String password;						//It can only be set once during registration	
	String firstName;						//It can only be set once during registration	
	String lastName;						//It can only be set once during registration	
	Address address;						//Mobile can only be set once during registration. 
											//Rest of address taken when entrying personal details
	String emailAddress;					//It can only be set once during registration	

	//Auto generated
	UpdateDetails updateDetails;
	Date createDate;				
	int totalConsecutiveFailures;			//Trigger account locking as per above
	Date lastPasswordChange;	
	Date lastForgotPassword;	
	int totalLogins;			

	//Not obtained during registration, but during personal details entry
	String title;					
	String middleName;	
	Gender gender;	
	String PAN;
	Date dateOfBirth;
	String incomeTaxWard;
	
	public void setRegistrationData(RegistrationData registrationData){
		username = registrationData.username;
		password = registrationData.password;
		firstName = registrationData.firstName;
		lastName = registrationData.lastName;
		address = new Address();
		address.mobileNumber = registrationData.mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getTotalConsecutiveFailures() {
		return totalConsecutiveFailures;
	}

	public void setTotalConsecutiveFailures(int totalConsecutiveFailures) {
		this.totalConsecutiveFailures = totalConsecutiveFailures;
	}

	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public Date getLastForgotPassword() {
		return lastForgotPassword;
	}

	public void setLastForgotPassword(Date lastForgotPassword) {
		this.lastForgotPassword = lastForgotPassword;
	}

	public int getTotalLogins() {
		return totalLogins;
	}

	public void setTotalLogins(int totalLogins) {
		this.totalLogins = totalLogins;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIncomeTaxWard() {
		return incomeTaxWard;
	}

	public void setIncomeTaxWard(String incomeTaxWard) {
		this.incomeTaxWard = incomeTaxWard;
	}

	public String getUsername() {
		return username;
	}
	
	public UserDetails(){
		//Offshore: Set constructor as needed
	}
	
	
}
