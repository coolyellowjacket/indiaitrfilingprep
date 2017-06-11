package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class ExemptionsData {
	Exemption[] exemptionSources;		//Each individual employer will be stored in giftIncomeSource

	public Exemption[] getExemptionSources() {
		return exemptionSources;
	}
	public void setExemptionSources(Exemption[] incomeSources) {
		this.exemptionSources = incomeSources;
	}
	
	@JsonIgnore public double getTotalExemption() {
		double totalExemptIncome = 0;
		if ( exemptionSources == null )
			return 0;
		else{
			for ( int i = 0; i < exemptionSources.length; i++ ){
				if(exemptionSources[i] != null)
					totalExemptIncome = totalExemptIncome + exemptionSources[i].getExemptValue();
			}
			return totalExemptIncome;
		}
			
	}

	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	@JsonIgnore public ExemptionsData(Exemption[] incomeSources){
		this.exemptionSources = incomeSources;
	}
	public ExemptionsData(){
		exemptionSources = new Exemption[23];
	}
	
	public String toString(){
		return this.getClass().getName() + " Total income: " + getTotalExemption() + " sources:" + exemptionSources;
	}
}
