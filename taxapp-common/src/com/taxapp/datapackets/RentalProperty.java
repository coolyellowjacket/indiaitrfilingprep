package com.taxapp.datapackets;

import java.util.Date;

import com.taxapp.enums.IncomeSourceType;
import com.taxapp.enums.IndianState;
import com.taxapp.enums.RentBenchmarkType;
import com.taxapp.enums.RentalDurationType;

public class RentalProperty extends IncomeSource{
	int ownsProperty;								//Needed primarily for UI side. Only if yes, do remaining steps.
	Address address;
	
	RentalDurationType rentalDurationType;
	
	double lastYearRentalIncomeRealizedNow;			//Last year rental income obtained from the tenant this year
	double realizedCurrentYearRentalIncome;			//Current year rental income obtained from the tenant
	double unrealizedCurrentYearRentalIncome;		//Current year rental income not yet obtained from the tenant
	
	double annualTaxesPaid;
	int hasLoanOnProperty;							//Needed primarily for UI side. Only if loan, consider interest paid.
	double interestPaid;
	
	RentBenchmarkType rentalBenchmarkValueType;
	double benchmarkRentValue;

	private Date constructionDate;					//disabled for now. Do not create getters / setters
	private Date loanSigningDate;					//disabled for now. Do not create getters / setters

	
	public int getOwnsProperty() {
		return ownsProperty;
	}
	public void setOwnsProperty(int ownsProperty) {
		this.ownsProperty = ownsProperty;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public RentalDurationType getRentalDurationType() {
		return rentalDurationType;
	}
	public void setRentalDurationType(RentalDurationType rentalDurationType) {
		this.rentalDurationType = rentalDurationType;
	}
	public double getLastYearRentalIncomeRealizedNow() {
		return lastYearRentalIncomeRealizedNow;
	}
	public void setLastYearRentalIncomeRealizedNow(
			double lastYearRentalIncomeRealizedNow) {
		this.lastYearRentalIncomeRealizedNow = lastYearRentalIncomeRealizedNow;
	}
	public double getRealizedCurrentYearRentalIncome() {
		return realizedCurrentYearRentalIncome;
	}
	public void setRealizedCurrentYearRentalIncome(
			double realizedCurrentYearRentalIncome) {
		this.realizedCurrentYearRentalIncome = realizedCurrentYearRentalIncome;
	}
	public double getUnrealizedCurrentYearRentalIncome() {
		return unrealizedCurrentYearRentalIncome;
	}
	public void setUnrealizedCurrentYearRentalIncome(
			double unrealizedCurrentYearRentalIncome) {
		this.unrealizedCurrentYearRentalIncome = unrealizedCurrentYearRentalIncome;
	}
	public double getAnnualTaxesPaid() {
		return annualTaxesPaid;
	}
	public void setAnnualTaxesPaid(double annualTaxesPaid) {
		this.annualTaxesPaid = annualTaxesPaid;
	}
	public int getHasLoanOnProperty() {
		return hasLoanOnProperty;
	}
	public void setHasLoanOnProperty(int hasLoanOnProperty) {
		this.hasLoanOnProperty = hasLoanOnProperty;
	}
	public double getInterestPaid() {
		return interestPaid;
	}
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}
	public RentBenchmarkType getRentalBenchmarkValueType() {
		return rentalBenchmarkValueType;
	}
	public void setRentalBenchmarkValueType(
			RentBenchmarkType rentalBenchmarkValueType) {
		this.rentalBenchmarkValueType = rentalBenchmarkValueType;
	}
	public double getBenchmarkRentValue() {
		return benchmarkRentValue;
	}
	public void setBenchmarkRentValue(double benchmarkRentValue) {
		this.benchmarkRentValue = benchmarkRentValue;
	}
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	
	public double getIncome(){
		return this.realizedCurrentYearRentalIncome + this.lastYearRentalIncomeRealizedNow - this.annualTaxesPaid;
	}
		
	public RentalProperty(){
		super();
		this.address = null;
		this.annualTaxesPaid = 0;
		this.benchmarkRentValue = 0;
		this.constructionDate = null;
		this.hasLoanOnProperty = 0;
		this.income = 0;
		this.incomeSourceType = IncomeSourceType.Rental;
		this.interestPaid = 0;
		this.lastYearRentalIncomeRealizedNow = 0;
		this.loanSigningDate = null;
		this.ownsProperty = 1;
		this.realizedCurrentYearRentalIncome = 0;
		this.rentalBenchmarkValueType = RentBenchmarkType.StandardRentValue;
		this.rentalDurationType = RentalDurationType.FullyRentedAllYear;
		this.taxDeductor = null;
		this.unrealizedCurrentYearRentalIncome = 0;
		this.updateDetails = null;
		this.userSessionInfo = null;
	}
}
