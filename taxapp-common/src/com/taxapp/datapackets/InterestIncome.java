package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;

public class InterestIncome extends IncomeSource{
	boolean isInterestFromSavingsAccount;

	public boolean isInterestFromSavingsAccount() {
		return isInterestFromSavingsAccount;
	}

	public void setInterestFromSavingsAccount(boolean isInterestFromSavingsAccount) {
		this.isInterestFromSavingsAccount = isInterestFromSavingsAccount;
	}
	
	public InterestIncome(){
		super();
		super.incomeSourceType = IncomeSourceType.Interest;
	}
	
	public boolean equals(InterestIncome incomeSource){
		boolean retVal = super.equals(incomeSource);
		
		if ( retVal == false )
			return false;
					
		if ( isInterestFromSavingsAccount == incomeSource.isInterestFromSavingsAccount() ){
			return true;
		}else{
			return false;
		}
		
	}
}
