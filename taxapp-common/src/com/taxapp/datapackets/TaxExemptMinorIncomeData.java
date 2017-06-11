package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class TaxExemptMinorIncomeData {
	TaxExemptMinorIncome[] taxExemptMinorIncomeSources;		//Each individual employer will be stored in giftIncomeSource

	public TaxExemptMinorIncome[] getTaxExemptMinorIncomeSources() {
		return taxExemptMinorIncomeSources;
	}
	public void setTaxExemptMinorIncomeSources(TaxExemptMinorIncome[] taxExemptMinorIncomeSources) {
		this.taxExemptMinorIncomeSources = taxExemptMinorIncomeSources;
	}
	
	@JsonIgnore public double getTotalTaxExemptMinorIncome() {
		double totalgiftIncome = 0;
		if ( taxExemptMinorIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < taxExemptMinorIncomeSources.length; i++ ){
				totalgiftIncome = totalgiftIncome + taxExemptMinorIncomeSources[i].getIncome();
			}
			return totalgiftIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		return getTotalTaxExemptMinorIncome();
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( taxExemptMinorIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < taxExemptMinorIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + taxExemptMinorIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}

	@JsonIgnore public void updateIncomeSource(TaxExemptMinorIncome updatedIncome, int index){
		taxExemptMinorIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(TaxExemptMinorIncome newIncome){
		int existingLength = taxExemptMinorIncomeSources.length;
		TaxExemptMinorIncome[] newIncomes = new TaxExemptMinorIncome[existingLength+1];
		for (int i=0; i< taxExemptMinorIncomeSources.length; i++)
			newIncomes[i] = taxExemptMinorIncomeSources[i];
		newIncomes[existingLength] = newIncome;
		this.taxExemptMinorIncomeSources = newIncomes;
	}

	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public TaxExemptMinorIncomeData(TaxExemptMinorIncome[] taxExemptMinorIncomeSources){
		this();
		this.taxExemptMinorIncomeSources = taxExemptMinorIncomeSources;
	}
	public TaxExemptMinorIncomeData(){
		this.taxExemptMinorIncomeSources = null;
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalTaxExemptMinorIncome() + " sources:" + taxExemptMinorIncomeSources;
	}
}
