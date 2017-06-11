package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;


public class SalaryIncome extends IncomeSource {
	
	//Income chargeable is the only item to be stored here, but income from superclass will suffice
	
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public SalaryIncome(){	
		super();
		this.incomeSourceType = IncomeSourceType.Salary;
	}

}
