package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.ExemptionLimits;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class AgricultureIncomeData {
	AgricultureIncome[] agricultureIncomeSources;		//Each individual employer will be stored in giftIncomeSource

	public AgricultureIncome[] getAgricultureIncomeSources() {
		return agricultureIncomeSources;
	}
	public void setAgricultureIncomeSources(AgricultureIncome[] agricultureIncomeSources) {
		this.agricultureIncomeSources = agricultureIncomeSources;
	}
	
	@JsonIgnore public double getTotalAgricultureIncome() {
		double totalIncome = 0;
		if ( agricultureIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < agricultureIncomeSources.length; i++ ){
				totalIncome = totalIncome + agricultureIncomeSources[i].getIncome();
			}
			return totalIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalIncome = getTotalAgricultureIncome();
		if (totalIncome <= ExemptionLimits.agricultureLimit)
			return totalIncome;
		else
			return ExemptionLimits.agricultureLimit;
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( agricultureIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < agricultureIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + agricultureIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public void updateIncomeSource(AgricultureIncome updatedIncome, int index){
		agricultureIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(AgricultureIncome newIncome){
		int existingLength = agricultureIncomeSources.length;
		AgricultureIncome[] newIncomes = new AgricultureIncome[existingLength+1];
		for (int i=0; i< agricultureIncomeSources.length; i++)
			newIncomes[i] = agricultureIncomeSources[i];
		newIncomes[existingLength] = newIncome;
		this.agricultureIncomeSources = newIncomes;
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public AgricultureIncomeData(AgricultureIncome[] agricultureIncomeSources){
		this();
		this.agricultureIncomeSources = agricultureIncomeSources;
	}
	public AgricultureIncomeData(){
		this.agricultureIncomeSources = null;
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalAgricultureIncome() + " sources:" + agricultureIncomeSources;
	}
}
