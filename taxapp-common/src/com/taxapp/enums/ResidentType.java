package com.taxapp.enums;

public enum ResidentType {
	NRI(1, "NRI"),
	Resident(2, "Resident"),
	NotOrdinaryResident(3,"NotOrdinaryResident"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	
	ResidentType(int value, String name){
		this.value = value;
		this.name = name;
	}
}
