package com.taxapp.datapackets;

import com.taxapp.utils.UpdateDetails;

public class TaxData {
	UserSessionInfo userSessionInfo;
	UpdateDetails updateDetails;
	double totalIncome;
	double totalExemptions;
	double taxableIncome;
	double taxPaid;
	double interest;
	double educationCess;					//3% of Tax Total Income
	double relief89;
	double relief90;
	double relief91;
	double taxDue;
	double additionalCharges;
	
	public double getAdditionalCharges() {
		return additionalCharges;
	}
	public void setAdditionalCharges(double additionalCharges) {
		this.additionalCharges = additionalCharges;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotalExemptions() {
		return totalExemptions;
	}
	public void setTotalExemptions(double totalExemptions) {
		this.totalExemptions = totalExemptions;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public double getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(double taxPaid) {
		this.taxPaid = taxPaid;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getRelief89() {
		return relief89;
	}
	public void setRelief89(double relief89) {
		this.relief89 = relief89;
	}
	public double getRelief90() {
		return relief90;
	}
	public void setRelief90(double relief90) {
		this.relief90 = relief90;
	}
	public double getRelief91() {
		return relief91;
	}
	public void setRelief91(double relief91) {
		this.relief91 = relief91;
	}
	public double getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(double taxDue) {
		this.taxDue = taxDue;
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
	public double getEducationCess() {
		return educationCess;
	}
	public void setEducationCess(double educationCess) {
		this.educationCess = educationCess;
	}
	public double getCessR89() {
		return relief89;
	}
	public void setCessR89(double cessR89) {
		this.relief89 = cessR89;
	}
	public double getCessR90() {
		return relief90;
	}
	public void setCessR90(double cessR90) {
		this.relief90 = cessR90;
	}
	public double getCessR91() {
		return relief91;
	}
	public void setCessR91(double cessR91) {
		this.relief91 = cessR91;
	}
	
	public TaxData(){
		//Offshore: create constructors as needed	

	}
	
}
