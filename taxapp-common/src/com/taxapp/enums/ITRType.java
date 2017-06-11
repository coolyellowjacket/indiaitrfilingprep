package com.taxapp.enums;

public enum ITRType {
	ITR1(1,"ITR1"),
	ITR2(2, "ITR2"),
	ITR3(3, "ITR3"),
	ITR4(4, "ITR4"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	
	ITRType(int value, String name){
		this.value = value;
		this.name = name;
	}
}
