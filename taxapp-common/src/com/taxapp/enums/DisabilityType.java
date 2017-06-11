package com.taxapp.enums;

public enum DisabilityType {
	Temporary(1,"Temporary"),
	Permanent(2, "Permanent"),
	Unknown(-1, "Unknown");
	
	public final int value;
	public final String name;
	
	DisabilityType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
