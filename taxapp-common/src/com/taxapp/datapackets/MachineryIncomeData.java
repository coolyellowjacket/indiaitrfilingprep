package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class MachineryIncomeData {
	MachineryIncome[] machineryIncomeSources;		//Each individual employer will be stored in giftIncomeSource

	public MachineryIncome[] getMachineryIncomeSources() {
		return machineryIncomeSources;
	}
	public void setMachineryIncomeSources(MachineryIncome[] incomeSources) {
		this.machineryIncomeSources = incomeSources;
	}
	
	@JsonIgnore public double getTotalMachineryIncome() {
		double totalgiftIncome = 0;
		if ( machineryIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < machineryIncomeSources.length; i++ ){
				totalgiftIncome = totalgiftIncome + machineryIncomeSources[i].getIncome();
			}
			return totalgiftIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( machineryIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < machineryIncomeSources.length; i++ ){
				totalExemptIncome = totalExemptIncome + machineryIncomeSources[i].getDepreciation() 
						+ machineryIncomeSources[i].getExpenses();
			}
			return totalExemptIncome;
		}
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( machineryIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < machineryIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + machineryIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public void updateIncomeSource(MachineryIncome updatedIncome, int index){
		machineryIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(MachineryIncome newIncome){
		int existingLength = machineryIncomeSources.length;
		MachineryIncome[] newIncomes = new MachineryIncome[existingLength+1];
		for (int i=0; i< machineryIncomeSources.length; i++)
			newIncomes[i] = machineryIncomeSources[i];
		newIncomes[existingLength] = newIncome;
		this.machineryIncomeSources = newIncomes;
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public MachineryIncomeData(MachineryIncome[] giftIncomeSources){
		this();
		this.machineryIncomeSources = giftIncomeSources;
	}
	public MachineryIncomeData(){
		this.machineryIncomeSources = null;
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalMachineryIncome() + " sources:" + machineryIncomeSources;
	}
}
