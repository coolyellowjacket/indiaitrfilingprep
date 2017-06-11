package com.taxapp.enums;

public enum IncomeSourceType {
	Salary(1,"Salary"),
	Interest(2, "Interest"),
	Rental(3, "Rental"),
	Machinery(4,"Machinery"),
	GiftFromRelative(5, "GiftFromRelative"),
	GiftFromOthers(6, "GiftFromOthers"),
	GiftFromInheritence(7, "GiftFromInheritence"),
	GiftFromSec10C20(8, "GiftFromSec10C20"),
	GiftFromSec10C23C(9, "GiftFromSec10C23C"),
	GiftFromInst23A(10, "GiftFromInst23A"),
	TaxableDividend(11, "TaxableDividend"),
	TaxExemptDividend(12, "TaxExemptDividend"),
	Agriculture(13, "Agriculture"),
	TaxExemptMinor(14, "TaxExemptMinor"),
	Unknown(-1,"Unknown");

	public final int value;
	public final String name;
	
	IncomeSourceType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
