package com.taxapp.datapackets;

import com.taxapp.enums.IncomeSourceType;

public class TaxExemptMinorIncome extends IncomeSource{
	public TaxExemptMinorIncome(){
		super();
		super.incomeSourceType = IncomeSourceType.TaxExemptMinor;
	}
}
