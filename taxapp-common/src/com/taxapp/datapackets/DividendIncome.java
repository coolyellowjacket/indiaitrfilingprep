package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;

public class DividendIncome extends IncomeSource{
	double taxExemptDividend;
	String dividendIssuer;
	String dividendIntermediaryBank;
	boolean isTaxExempt;
	
	public boolean isTaxExempt() {
		return isTaxExempt;
	}

	public void setTaxExempt(boolean isTaxExempt) {
		this.isTaxExempt = isTaxExempt;
	}

	public String getDividendIssuer() {
		return dividendIssuer;
	}

	public void setDividendIssuer(String dividendIssuer) {
		this.dividendIssuer = dividendIssuer;
	}

	public String getDividendIntermediaryBank() {
		return dividendIntermediaryBank;
	}

	public void setDividendIntermediaryBank(String dividendIntermediaryBank) {
		this.dividendIntermediaryBank = dividendIntermediaryBank;
	}

	public double getTaxExemptDividend() {
		return taxExemptDividend;
	}

	public void setTaxExemptDividend(double taxExemptDividend) {
		this.taxExemptDividend = taxExemptDividend;
		this.isTaxExempt = true;
	}
	
	public double getDividend() {
		return income;
	}

	public void setDividend(double dividend) {
		super.income = dividend;
		this.isTaxExempt = false;
	}
	
	public DividendIncome(){
		super();
		this.taxExemptDividend = 0;
		this.dividendIssuer = "";
		this.dividendIntermediaryBank = "";
		this.isTaxExempt = false;

	}
	
	public boolean equals(DividendIncome incomeSource){
		boolean retVal = super.equals(incomeSource);
		
		if ( retVal == false )
			return false;
					
		if ( isTaxExempt == incomeSource.isTaxExempt() ){
			return true;
		}else{
			return false;
		}
		
	}

}
