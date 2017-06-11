package com.taxapp.enums;

public enum Gender {
	Male(1,"Male"),
	Female(2, "Male"),
	Unknown(-1, "Unknown");
	
	public final int value;
	public final String name;
	
	Gender(int value, String name){
		this.value = value;
		this.name = name;
	}

}
