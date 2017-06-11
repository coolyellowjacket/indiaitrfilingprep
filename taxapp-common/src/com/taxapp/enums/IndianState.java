package com.taxapp.enums;

public enum IndianState {
	AP(1,"AndhraPradesh");
	//Offshore: Create all states in alphabetical order;
	
	public final int value;
	public final String name;
	IndianState(int value, String name){
		this.value = value;
		this.name = name;
	}

}
