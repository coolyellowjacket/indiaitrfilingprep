package com.taxapp.enums;

public enum CommunicationsModuleType {
	Login(1,"Login"),
	IncomeTypeDefinition(2, "IncomeTypeDefinition"), 
	Response(3,"Response"),
	Registration(4,"Registration"),
	ITRClassification(5,"ITRClassification"),
	ITR_1_Classification(6,"ITR_1_Classification"),
	RentalProperty(7,"RentalProperty"),
	RentalIncome(8,"RentalIncome"),
	ITRData(9,"ITRData"),
	SalaryIncome(10,"SalaryIncome"),
	UserSessionInfo(11,"UserSessionInfo"),
	GiftIncome(12,"GiftIncome"),
	InterestIncome(13,"InterestIncome"),
	DividendIncome(14,"DividendIncome"),
	MachineryIncome(15,"MachineryIncome"),
	AgricultureIncome(16,"AgricultureIncome"),
	TaxExemptMinorIncome(17,"TaxExemptMinorIncome"),
	Exemptions(18,"Exemptions"),
	EmailXML(19,"EmailXML"),
	FileXML(20,"FileXML"),
	AllData(21,"AllData"),
	Payments(22,"Payments"),
	UserDetails(23,"UserDetails"),
	TaxReport(24,"TaxReport"),
	Unknown(-1, "Unknown");

	public final int value;
	public final String name;
	
	CommunicationsModuleType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
