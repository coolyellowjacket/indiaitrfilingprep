package com.taxapp.datapackets;

import com.taxapp.enums.ExemptionType;
import com.taxapp.utils.UpdateDetails;

public class Exemption {
	UserSessionInfo userSessionInfo;
	UpdateDetails updateDetails;
	ExemptionType exemptionType;
	double exemptValue;
	public ExemptionType getExemptionType() {
		return exemptionType;
	}
	public void setExemptionType(ExemptionType exemptionType) {
		this.exemptionType = exemptionType;
	}
	public double getExemptValue() {
		return exemptValue;
	}
	public void setExemptValue(double exemptValue) {
		this.exemptValue = exemptValue;
	}
	public UserSessionInfo getUserSessionInfo() {
		return userSessionInfo;
	}
	public void setUserSessionInfo(UserSessionInfo userSessionInfo) {
		this.userSessionInfo = userSessionInfo;
	}
	public UpdateDetails getUpdateDetails() {
		return updateDetails;
	}
	public void setUpdateDetails(UpdateDetails updateDetails) {
		this.updateDetails = updateDetails;
	}
	
	public Exemption(ExemptionType exemptionType, double exemptValue){
		setExemptionType(exemptionType);
		setExemptValue(exemptValue);
	}
	
	public Exemption(){
	
	}
	
}
