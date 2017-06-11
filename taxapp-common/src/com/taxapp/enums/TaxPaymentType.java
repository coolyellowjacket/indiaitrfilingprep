package com.taxapp.enums;

public enum TaxPaymentType {
	SelfAssessment(1,"SelfAssessment"),
	AdvancePayment(2,"AdvancePayment"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	TaxPaymentType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
