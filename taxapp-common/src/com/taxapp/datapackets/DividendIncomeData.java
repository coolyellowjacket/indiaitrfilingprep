package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class DividendIncomeData {
	DividendIncome[] dividendIncomeSources;		//Each individual employer will be stored in giftIncomeSource

	public DividendIncome[] getDividendIncomeSources() {
		return dividendIncomeSources;
	}
	public void setDividendIncomeSources(DividendIncome[] dividendIncomeSources) {
		this.dividendIncomeSources = dividendIncomeSources;
	}
	
	@JsonIgnore public double getTotalDividendIncome() {
		double totalIncome = 0;
		if ( dividendIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < dividendIncomeSources.length; i++ ){
				totalIncome = totalIncome + dividendIncomeSources[i].getIncome();
			}
			return totalIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( dividendIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < dividendIncomeSources.length; i++ ){
				if (dividendIncomeSources[i].isTaxExempt)
					totalExemptIncome = totalExemptIncome + dividendIncomeSources[i].getIncome();
			}
			return totalExemptIncome;
		}
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( dividendIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < dividendIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + dividendIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public void updateIncomeSource(DividendIncome updatedIncome, int index){
		dividendIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(DividendIncome newIncome){
		int existingLength = dividendIncomeSources.length;
		DividendIncome[] newIncomes = new DividendIncome[existingLength+1];
		for (int i=0; i< dividendIncomeSources.length; i++)
			newIncomes[i] = dividendIncomeSources[i];
		newIncomes[existingLength] = newIncome;
		this.dividendIncomeSources = newIncomes;
	}

	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public DividendIncomeData(DividendIncome[] dividendIncomeSources){
		this();
		this.dividendIncomeSources = dividendIncomeSources;
	}
	public DividendIncomeData(){
		this.dividendIncomeSources = null;		
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalDividendIncome() + " sources:" + dividendIncomeSources;
	}
}
