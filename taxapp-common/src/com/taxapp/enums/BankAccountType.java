package com.taxapp.enums;

public enum BankAccountType {
	Checking(1,"Checking"),
	Saving(2,"Saving"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	BankAccountType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
