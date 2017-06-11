package com.taxapp.enums;

public enum GifterType {
	Relative(1,"Relative"),
	Inheritence(2,"Inheritence"),
	Marriage(2,"Marriage"),
	Other(3,"Other"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	GifterType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
