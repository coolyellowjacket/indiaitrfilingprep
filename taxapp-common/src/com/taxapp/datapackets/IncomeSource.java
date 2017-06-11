package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.IncomeSourceType;
import com.taxapp.utils.UpdateDetails;

public class IncomeSource {
	UserSessionInfo userSessionInfo;
	UpdateDetails updateDetails;
	TaxDeductor taxDeductor;
	double income=0;
	IncomeSourceType incomeSourceType;
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
	public TaxDeductor getTaxDeductor() {
		return taxDeductor;
	}
	public void setTaxDeductor(TaxDeductor taxDeductor) {
		this.taxDeductor = taxDeductor;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public IncomeSourceType getIncomeSourceType() {
		return incomeSourceType;
	}
	public void setIncomeSourceType(IncomeSourceType incomeSourceType) {
		this.incomeSourceType = incomeSourceType;
	}
	
	public IncomeSource(){
		this.userSessionInfo = null;
		this.updateDetails = null;
		this.income = 0;
		this.incomeSourceType = IncomeSourceType.Unknown;
	}
	
	@JsonIgnore public double getTotalDeductions(){
		if ( taxDeductor == null ){
			return 0;
		}else{
			return taxDeductor.getTotalDeductions();
		}		
	}
	
	public IncomeSource(double income, IncomeSourceType incomeSourceType){
		this.income = income;
		this.incomeSourceType = incomeSourceType;
	}
	public String toString(){
		return this.getClass().getName() + "income:" + income + " incomeSourceType:" + incomeSourceType 
				+ " tax deductor:" + taxDeductor.toString();
	}
	
	public boolean equals(IncomeSource incomeSource){
		
		if (incomeSource == null)
			return false;
		
		if ( incomeSource.income != this.income)
			return false;
		
		if (incomeSource.incomeSourceType != this.incomeSourceType)
			return false;
		
		if (!incomeSource.taxDeductor.equals(this.taxDeductor))
			return false;

		return true;
	}
	
}
