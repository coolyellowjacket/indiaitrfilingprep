package com.taxapp.enums;

public enum FilingTiming {
	BeforeDueDate(1,"BeforeDueDate"),
	AfterDueDate(2,"AfterDueDate"),
	Revised(3,"Revised"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	FilingTiming(int value, String name){
		this.value = value;
		this.name = name;
	}

}
