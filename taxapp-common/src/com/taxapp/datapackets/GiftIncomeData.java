package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.ExemptionLimits;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class GiftIncomeData {
	GiftIncome[] giftIncomeSources;		//Each individual employer will be stored in giftIncomeSource

	public GiftIncome[] getGiftIncomeSources() {
		return giftIncomeSources;
	}
	public void setGiftIncomeSources(GiftIncome[] giftIncomeSources) {
		this.giftIncomeSources = giftIncomeSources;
	}
	
	@JsonIgnore public double getTotalGiftIncome() {
		double totalgiftIncome = 0;
		if ( giftIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < giftIncomeSources.length; i++ ){
				totalgiftIncome = totalgiftIncome + giftIncomeSources[i].getIncome();
			}
			return totalgiftIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( giftIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < giftIncomeSources.length; i++ ){
				if (giftIncomeSources[i].isFromRelative())
					totalExemptIncome = totalExemptIncome + giftIncomeSources[i].getIncome();
			}
		}
		
		if (totalExemptIncome <= ExemptionLimits.giftIncomeLimit)
			return totalExemptIncome;
		else
			return ExemptionLimits.agricultureLimit;

	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( giftIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < giftIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + giftIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public void updateIncomeSource(GiftIncome updatedIncome, int index){
		giftIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(GiftIncome newIncome){
		int existingLength = giftIncomeSources.length;
		GiftIncome[] newIncomes = new GiftIncome[existingLength+1];
		for (int i=0; i< giftIncomeSources.length; i++)
			newIncomes[i] = giftIncomeSources[i];
		newIncomes[existingLength] = newIncome;
		this.giftIncomeSources = newIncomes;
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public GiftIncomeData(GiftIncome[] giftIncomeSources){
		this();
		this.giftIncomeSources = giftIncomeSources;
	}
	public GiftIncomeData(){
		this.giftIncomeSources = null;
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalGiftIncome() + " sources:" + giftIncomeSources;
	}
}
