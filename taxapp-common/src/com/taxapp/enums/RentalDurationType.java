package com.taxapp.enums;

public enum RentalDurationType {
	FullyRentedAllYear(1,"FullyRentedAllYear"),
	PartiallyRentedAllYear(2, "PartiallyRentedAllYear"),
	FullyOccupiedBySelfAllYear(3, "FullyOccupiedBySelfAllYear"),
	PartiallyRentedPartialYear(4, "PartiallyRentedPartialYear"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	
	RentalDurationType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
