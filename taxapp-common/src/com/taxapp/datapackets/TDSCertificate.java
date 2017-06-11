package com.taxapp.datapackets;

import com.taxapp.utils.UpdateDetails;

public class TDSCertificate {
	String certificateId="";
	double taxDeduction=0;
	TaxDeductor taxDeductor;
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public double getDeduction() {
		return taxDeduction;
	}
	public void setDeduction(double deduction) {
		this.taxDeduction = deduction;
	}
	public TaxDeductor getTaxDeductor() {
		return taxDeductor;
	}
	public void setTaxDeductor(TaxDeductor taxDeductor) {
		this.taxDeductor = taxDeductor;
	}
	
	public TDSCertificate(	String certificateId, double taxDeduction){
		setCertificateId(certificateId);
		setDeduction(taxDeduction);
	}
	
	public TDSCertificate(){
		certificateId = "";
		taxDeduction = 0;
	}
	
	public String toString(){
		return " certificateId;" + certificateId + " tax deduction:" + taxDeduction;
	}
	
	public boolean equals(TDSCertificate tdsCertificate){
		
		if (tdsCertificate == null)
			return false;

		if(tdsCertificate.certificateId != this.certificateId)
			return false;
		
		if(tdsCertificate.taxDeduction != this.taxDeduction)
			return false;
		
		return true;
	}
}
