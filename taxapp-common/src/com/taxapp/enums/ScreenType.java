package com.taxapp.enums;

public enum ScreenType {
	Login(1,"Login"),
	IncomeTypeDefinition(2,"IncomeTypeDefinition"),
	ITRClassification(3,"ITRClassification"),
	RentalIncomeDetails(4,"RentalIncomeDetails"),
	SalaryIncomeDetails(5,"SalaryIncomeDetails"),
	InterestIncomeDetails(6,"InterestIncomeDetails"),
	MachineryIncomeDetails(7,"MachineryIncomeDetails"),
	AgricultureIncomeDetails(8,"AgricultureIncomeDetails"),
	MinorIncomeDetails(9,"MinorIncomeDetails"),
	DividendIncomeDetails(10,"DividendIncomeDetails"),
	Exemptions(11,"Exemptions"),
	GiftIncomeDetails(12,"GiftIncomeDetails"),
	PaymentDetails(13,"Payments"),
	DeleteSalary(14,"DeleteSalary"),
	DeleteRental(15,"DeleteRental"),
	DeleteInterest(16,"DeleteInterest"),
	DeleteGift(17,"DeleteGift"),
	DeleteDividend(18,"DeleteDividend"),
	DeleteMachinery(19,"DeleteMachinery"),
	DeleteMinor(20,"DeleteMinor"),
	DeleteAgriculture(21,"DeleteAgriculture"),
	DeletePayment(22,"DeletePayment"),
	Registration(23,"Registration"),
	PersonalDetails(24,"PersonalDetails"),
	TaxReport(25,"TaxReport"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	ScreenType(int value, String name){
		this.value = value;
		this.name = name;
	}
}
