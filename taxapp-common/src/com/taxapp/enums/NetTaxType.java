package com.taxapp.enums;

public enum NetTaxType {
	Unknown(-1,"Unknown"),
	Refund(1,"Refund"),
	Payable(2,"Payable"),
	NilTaxBalance(3,"NilTaxBalance");
	
	public final int value;
	public final String name;
	
	NetTaxType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
