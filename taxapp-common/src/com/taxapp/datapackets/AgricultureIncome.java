package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;

public class AgricultureIncome extends IncomeSource{
	public AgricultureIncome(){
		super();
		super.incomeSourceType = IncomeSourceType.Agriculture;
	}
}
