package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.ExemptionLimits;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class InterestIncomeData {
	InterestIncome[] interestIncomeSources;		//Each individual  will be stored in incomeSource

	public InterestIncome[] getInterestIncomeSources() {
		return interestIncomeSources;
	}
	public void setInterestIncomeSources(InterestIncome[] incomeSources) {
		this.interestIncomeSources = incomeSources;
	}
	
	@JsonIgnore public double getTotalInterestIncome() {
		double totalIncome = 0;
		if ( interestIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < interestIncomeSources.length; i++ ){
				totalIncome = totalIncome + interestIncomeSources[i].getIncome();
			}
			return totalIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( interestIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < interestIncomeSources.length; i++ ){
				if (interestIncomeSources[i].isInterestFromSavingsAccount)
					totalExemptIncome = totalExemptIncome + interestIncomeSources[i].getIncome();
			}
		}
		
		if(totalExemptIncome < ExemptionLimits.interestIncomeLimit)
			return totalExemptIncome;
		else
			return ExemptionLimits.interestIncomeLimit;
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( interestIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < interestIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + interestIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	
	@JsonIgnore public void updateIncomeSource(InterestIncome updatedIncome, int index){
		interestIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(InterestIncome newIncome){
		InterestIncome[] newIncomes;
		
		if(this.interestIncomeSources != null){
		int existingLength = interestIncomeSources.length;
			newIncomes = new InterestIncome[existingLength+1];
			for (int i=0; i< interestIncomeSources.length; i++)
				newIncomes[i] = interestIncomeSources[i];
			newIncomes[existingLength] = newIncome;
		}else{
			newIncomes = new InterestIncome[1];
			newIncomes[0] = newIncome;
		}
			
		this.interestIncomeSources = newIncomes;
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}

	public InterestIncomeData(){
		this.interestIncomeSources = null;		
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalInterestIncome() + " sources:" + interestIncomeSources;
	}
}
