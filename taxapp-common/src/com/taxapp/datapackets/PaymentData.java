package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.TaxPaymentType;
import com.taxapp.utils.UpdateDetails;

//This class is a consolidation of all salary incomes

public class PaymentData {
	Payment[] payments;		//Each individual employer will be stored in giftIncomeSource

	public Payment[] getPayments() {
		return payments;
	}

	public void setPayments(Payment[] payments) {
		this.payments = payments;
	}

	@JsonIgnore public double getTotalPayments(){
		double totalPayments = 0;
		if ( payments == null )
			return 0;
		else{
			for ( int i = 0; i < payments.length; i++ ){
				totalPayments = totalPayments + payments[i].getTaxPaid();
			}
			return totalPayments;
		}
	}
	
	@JsonIgnore public double getTotalAdvancePayments(){
		double totalPayments = 0;
		if ( payments == null )
			return 0;
		else{
			for ( int i = 0; i < payments.length; i++ ){
				if (payments[i].paymentType == TaxPaymentType.AdvancePayment)
					totalPayments = totalPayments + payments[i].getTaxPaid();
			}
			return totalPayments;
		}
	}
	
	@JsonIgnore public double getTotalSelfAssessmentPayments(){
		double totalPayments = 0;
		if ( payments == null )
			return 0;
		else{
			for ( int i = 0; i < payments.length; i++ ){
				if (payments[i].paymentType == TaxPaymentType.SelfAssessment)
					totalPayments = totalPayments + payments[i].getTaxPaid();
			}
			return totalPayments;
		}
	}

	@JsonIgnore public void updatePayment(Payment payment, int index){
		payments[index] = payment;
	}
	
	@JsonIgnore public void addPayment(Payment payment){
		Payment[] newPayments;
		
		if(payments != null){
			int existingLength = payments.length;
			newPayments = new Payment[existingLength+1];
			for (int i=0; i< payments.length; i++)
				newPayments[i] = payments[i];
			newPayments[existingLength] = payment;
			this.payments = newPayments;
		}else{
			newPayments = new Payment[1];
			newPayments[0] = payment;
		}
		
		this.payments = newPayments;
			
	}


	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public PaymentData(Payment[] payments){
		this();
		this.payments = payments;
	}
	public PaymentData(){
		this.payments = null;		
	}
	
	public String toString(){
		return this.getClass().getName() + " Total tax payments: " + getTotalPayments();
	}
}
