package com.taxapp.datapackets;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class SalaryIncomeData {
	SalaryIncome[] salaryIncomeSources;		//Each individual employer will be stored in salaryIncomeSource

	public SalaryIncome[] getSalaryIncomeSources() {
		return salaryIncomeSources;
	}
	public void setSalaryIncomeSources(SalaryIncome[] salaryIncomeSources) {
		this.salaryIncomeSources = salaryIncomeSources;
	}
	
	@JsonIgnore public double getTotalSalaryIncome() {
		double totalSalaryIncome = 0;
		if ( salaryIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < salaryIncomeSources.length; i++ ){
				totalSalaryIncome = totalSalaryIncome + salaryIncomeSources[i].getIncome();
			}
			return totalSalaryIncome;
		}
	}
	
	@JsonIgnore public double getTotalExemptIncome(){
		double totalExemptIncome = 0;
		if ( salaryIncomeSources == null )
			return 0;
		else{
//			for ( int i = 0; i < salaryIncomeSources.length; i++ ){
//				if (salaryIncomeSources[i].isTaxExempt)
//					totalExemptIncome = totalExemptIncome + salaryIncomeSources[i].getIncome();
//			}
			return totalExemptIncome;
		}
	}

	@JsonIgnore public double getTotalDeductions(){
		double totalDeduction = 0;
		if ( salaryIncomeSources == null )
			return 0;
		else{
			for ( int i = 0; i < salaryIncomeSources.length; i++ ){
				totalDeduction = totalDeduction + salaryIncomeSources[i].getTotalDeductions();
			}
			return totalDeduction;
		}
	}
	
	@JsonIgnore public void updateIncomeSource(SalaryIncome updatedIncome, int index){
		salaryIncomeSources[index] = updatedIncome;
	}
	
	@JsonIgnore public void addIncomeSource(SalaryIncome newIncome){
		SalaryIncome[] newSalaryIncomes;
		
		if(salaryIncomeSources != null){
			int existingLength = salaryIncomeSources.length;
			newSalaryIncomes = new SalaryIncome[existingLength+1];
			for (int i=0; i< salaryIncomeSources.length; i++)
				newSalaryIncomes[i] = salaryIncomeSources[i];
			newSalaryIncomes[existingLength] = newIncome;
		}else{
			newSalaryIncomes = new SalaryIncome[1];
			newSalaryIncomes[0] = newIncome;
		}
		this.salaryIncomeSources = newSalaryIncomes;
	}
	
	
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public SalaryIncomeData(SalaryIncome[] salaryIncomeSources){
		this();
		this.salaryIncomeSources = salaryIncomeSources;
	}
	public SalaryIncomeData(){
		this.salaryIncomeSources = null;
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalSalaryIncome() + " sources:" + salaryIncomeSources;
	}
}
