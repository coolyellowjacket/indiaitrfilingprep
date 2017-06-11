package com.taxapp.enums;

public enum RentBenchmarkType {
	MunicipalValue(1,"MunicipalValue"),
	FairRentValue(2,"FairRentValue"),
	StandardRentValue(3,"StandardRentValue"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	RentBenchmarkType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
