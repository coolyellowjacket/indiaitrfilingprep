package com.taxapp.enums;

public enum RefundOrPaymentType {
	Check(1,"Check"),
	Direct(2,"Direct"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	RefundOrPaymentType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
