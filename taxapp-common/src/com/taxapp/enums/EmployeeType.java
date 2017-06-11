package com.taxapp.enums;

public enum EmployeeType {
	PSU(1,"PSU"),
	Government(2,"Govt"),
	Other(3,"Other"),
	Unknown(-1,"Unknown");
	//Offshore: Create all states in alphabetical order;
	
	public final int value;
	public final String name;
	EmployeeType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
