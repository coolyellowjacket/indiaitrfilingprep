package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.EmployeeType;
import com.taxapp.enums.ITRType;
import com.taxapp.enums.ResidentType;

public class ITRClassificationData {
	ResidentType residentType;			//Not ITR1 if not resident
	int hasMultipleHouses;				//Not ITR1 if has > 1 rental house
	EmployeeType employeeType;			
	int hasForeignAssets;				//Not ITR1 if has foreign assets
	int isFilingAsHuf;					//Not ITR1 if HUF
	int hasBusiness;					//Not ITR1 if has business
	int isPartner;						// "Default value should be 0, 1 :: ITR3 Boolean response should be stored as 0/1
	int hasCapitalGainsIncome;			//Not ITR1 if has cap gains
	int hasLotteryIncome;				//Not ITR1 if has lottery
	int hasHorseracingIncome;			//Not ITR1 if has horse racing
	int hasCarryForwardLoss;			//Not ITR1 if has house has loss
	
	public ResidentType getResidentType() {
		return residentType;
	}
	public void setResidentType(ResidentType residentType) {
		this.residentType = residentType;
	}
	public int getIsFilingAsHuf() {
		return isFilingAsHuf;
	}
	public void setIsFilingAsHuf(int isFilingAsHuf) {
		this.isFilingAsHuf = isFilingAsHuf;
	}
	public int getHasMultipleHouses() {
		return hasMultipleHouses;
	}
	public int getHasForeignAssets() {
		return hasForeignAssets;
	}
	public int getHasCapitalGainsIncome() {
		return hasCapitalGainsIncome;
	}
	public int getHasLotteryIncome() {
		return hasLotteryIncome;
	}
	public int getHasHorseracingIncome() {
		return hasHorseracingIncome;
	}
	public void setIsPartner(int isPartner) {
		this.isPartner = isPartner;
	}
	public int getHasCarryForwardLoss() {
		return hasCarryForwardLoss;
	}
	public int getHasBusiness(){
		return hasBusiness;
	}
	public int getIsPartner() {
		return isPartner;
	}
	public void setHasCarryForwardLoss(int hasCarryForwardLoss) {
		this.hasCarryForwardLoss = hasCarryForwardLoss;
	}
	public ResidentType residentType() {
		return residentType;
	}
	public void setResident(ResidentType residentType) {
		this.residentType = residentType;
	}
	@JsonIgnore public int isHasForeignAssets() {
		return hasForeignAssets;
	}
	public void setHasForeignAssets(int hasForeignAssets) {
		this.hasForeignAssets = hasForeignAssets;
	}
	@JsonIgnore public int isFilingAsHuf() {
		return isFilingAsHuf;
	}
	public void setFilingAsHuf(int isFilingAsHUF) {
		this.isFilingAsHuf = isFilingAsHUF;
	}
	@JsonIgnore public int isHasBusiness() {
		return hasBusiness;
	}
	public void setHasBusiness(int hasBusiness) {
		this.hasBusiness = hasBusiness;
	}
	@JsonIgnore public int isHasCapitalGainsIncome() {
		return hasCapitalGainsIncome;
	}
	public void setHasCapitalGainsIncome(int hasCapitalGainsIncome) {
		this.hasCapitalGainsIncome = hasCapitalGainsIncome;
	}
	@JsonIgnore public int isHasLotteryIncome() {
		return hasLotteryIncome;
	}
	public void setHasLotteryIncome(int hasLotteryIncome) {
		this.hasLotteryIncome = hasLotteryIncome;
	}
	@JsonIgnore public int isHasHorseracingIncome() {
		return hasHorseracingIncome;
	}
	public void setHasHorseracingIncome(int hasHorseracingIncome) {
		this.hasHorseracingIncome = hasHorseracingIncome;
	}
	public int hasMultipleHouses() {
		return hasMultipleHouses;
	}
	public void setHasMultipleHouses(int numRentedHouses) {
		this.hasMultipleHouses = numRentedHouses;
	}
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public ITRClassificationData(){	
		//Offshore: set values based on variables above	
	}

	@JsonIgnore public ITRType getITRType(){
		ITRType itrType = ITRType.ITR1;	
		return itrType;
	}

	@JsonIgnore public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	
	@JsonIgnore public ITRClassificationData(ResidentType residentType,
			int numRentedHouses,
			EmployeeType employeeType,			
			int hasForeignAssets,			
			int isFilingAsHuf,				
			int hasBusiness,				
			int isPartner,		
			int hasCapitalGainsIncome,	
			int hasLotteryIncome,		
			int hasHorseracingIncome,			
			int hasCarryForwardLoss		
			){
		setResident(residentType);
		setHasMultipleHouses(numRentedHouses);
		setEmployeeType(employeeType);
		setFilingAsHuf(isFilingAsHuf);
		setHasBusiness(hasBusiness);
		setHasCapitalGainsIncome(hasCapitalGainsIncome);
		setHasForeignAssets(hasForeignAssets);
		setHasHorseracingIncome(hasHorseracingIncome);
		setHasLotteryIncome(hasLotteryIncome);
	}


}
