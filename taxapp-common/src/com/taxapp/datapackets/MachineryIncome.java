package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;

public class MachineryIncome extends IncomeSource{
	double expenses;
	double depreciation;
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	public double getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}
	public MachineryIncome(){
		super();
		super.incomeSourceType = IncomeSourceType.Machinery;
		this.expenses = 0;
		this.depreciation = 0;
	}
	
	public boolean equals(MachineryIncome incomeSource){
		boolean retVal = super.equals(incomeSource);
		
		if ( retVal == false )
			return false;
					
		if ( expenses != incomeSource.getExpenses() )
			return false;
		
		if ( depreciation != incomeSource.getDepreciation() )
			return false;
		else
			return true;
		
	}

}
