package com.taxapp.datapackets;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.ExemptionLimits;
import com.taxapp.enums.RentalDurationType;

public class RentalIncomeData{
	Logger log;
	RentalProperty[] rentalProperties;

	public RentalProperty[] getRentalProperties() {
		return rentalProperties;
	}
	public void setRentalProperties(RentalProperty[] rentalProperties) {
		this.rentalProperties = rentalProperties;
	}
	
	@JsonIgnore public String getTypeOfHP(){
		if (rentalProperties==null)
			return null;
		
		if (rentalProperties.length > 1){
			log.log(Level.INFO, "Rental properties over 1. ITR 1 does not apply");
			return null;
		}
		
		if (rentalProperties.length < 1)
			return null;

		if (rentalProperties[0].rentalDurationType == RentalDurationType.Unknown){
			log.log(Level.SEVERE, "Rental properties has unknown rental duration type");
			return null;
		}
		
		if (rentalProperties[0].rentalDurationType == RentalDurationType.FullyOccupiedBySelfAllYear)
			return "S";
		else
			return "L";
	}
	
	@JsonIgnore public double getTotalRentalIncome() {
		double totalIncome = 0;
		if ( rentalProperties == null )
			return 0;
		else{
			for ( int i = 0; i < rentalProperties.length; i++ ){
				totalIncome = totalIncome + rentalProperties[i].getIncome();
			}
			return totalIncome;
		}
	}
	
	@JsonIgnore public double getTotalInterestPaid() {
		double totalInterest = 0;
		if ( rentalProperties == null )
			return 0;
		else{
			for ( int i = 0; i < rentalProperties.length; i++ ){
				totalInterest = totalInterest + rentalProperties[i].getInterestPaid();
			}
			return totalInterest;
		}
	}

	
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( rentalProperties == null )
			return 0;
		else{
			if(getTotalInterestPaid() > ExemptionLimits.rentalIncomeInterestLimit)
				totalExemptIncome = ( getTotalRentalIncome() * ExemptionLimits.rentalIncomeRatio ) + ExemptionLimits.rentalIncomeInterestLimit;
			else
				totalExemptIncome = ( getTotalRentalIncome() * ExemptionLimits.rentalIncomeRatio ) + getTotalInterestPaid();
			
			return totalExemptIncome;
		}
	}
	
	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( rentalProperties == null )
			return 0;
		else{
			for ( int i = 0; i < rentalProperties.length; i++ ){
				totalDeduction = totalDeduction + rentalProperties[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public int getNumberOfRentalProperties(){
		if (rentalProperties == null)
			return 0;
		else
			return rentalProperties.length;
	}
	
	@JsonIgnore public void updateIncomeSource(RentalProperty updatedIncome, int index){
		rentalProperties[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(RentalProperty newIncome){
		int existingLength = rentalProperties.length;
		RentalProperty[] newSalaryIncomes = new RentalProperty[existingLength+1];
		for (int i=0; i< rentalProperties.length; i++)
			newSalaryIncomes[i] = rentalProperties[i];
		newSalaryIncomes[existingLength] = newIncome;
		this.rentalProperties = newSalaryIncomes;
	}

	public RentalIncomeData(RentalProperty[] rentalProperties){
		this();
		this.rentalProperties = rentalProperties;
	}
	public RentalIncomeData(){
		log = Logger.getLogger(RentalIncomeData.class.getName());
		this.rentalProperties = null;
	}

	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
}
