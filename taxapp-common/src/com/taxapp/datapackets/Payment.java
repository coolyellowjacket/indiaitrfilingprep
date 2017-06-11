package com.taxapp.datapackets;

import java.util.Date;

import com.taxapp.enums.TaxPaymentType;
import com.taxapp.utils.UpdateDetails;

public class Payment {
	UserSessionInfo userSessionInfo;
	UpdateDetails updateDetails;
	TaxPaymentType paymentType;
	Date advancedTaxTargetDate;
	String BSRCode;
	Date paymentDate;
	String challanNum;
	double taxPaid;
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
	public TaxPaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(TaxPaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getBSRCode() {
		return BSRCode;
	}
	public void setBSRCode(String bSRCode) {
		BSRCode = bSRCode;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getChallanNum() {
		return challanNum;
	}
	public void setChallanNum(String challanNum) {
		this.challanNum = challanNum;
	}
	public double getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(double taxPaid) {
		this.taxPaid = taxPaid;
	}
	
	public Payment(){
		//Offshore: create constructors as needed	
	}
	
}
