package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.GifterType;
import com.taxapp.enums.IncomeSourceType;

public class GiftIncome extends IncomeSource{
	double stampDutyFairMarketValue;
	GifterType gifterType;
	
	public GifterType getGifterType() {
		return gifterType;
	}

	public void setGifterType(GifterType gifterType) {
		this.gifterType = gifterType;
	}

	@Override public double getIncome() {
		return stampDutyFairMarketValue;
	}

	@Override public void setIncome(double income) {
		this.stampDutyFairMarketValue = income;
	}
	
	@JsonIgnore
	public boolean isFromRelative(){
		if (gifterType == null)
			return false;
		
		if (gifterType.equals(GifterType.Inheritence) || gifterType.equals(GifterType.Marriage) 
				|| gifterType.equals(GifterType.Relative))
			return true;
		else
			return false;
			
	}
	
	public GiftIncome(){
		super();
		this.stampDutyFairMarketValue = 0;
		this.gifterType = GifterType.Unknown;
	}
}
