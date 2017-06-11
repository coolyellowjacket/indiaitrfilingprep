package com.taxapp.datapackets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.utils.UpdateDetails;

public class TaxDeductor {
	String TAN = "";
	String deductorName = "";
	String deductorNickname = "";
	TDSCertificate[] TDSCertificates;
	public String getTAN() {
		return TAN;
	}
	public void setTAN(String tAN) {
		TAN = tAN;
	}
	public String getDeductorName() {
		return deductorName;
	}
	public void setDeductorName(String deductorName) {
		this.deductorName = deductorName;
	}
	public String getDeductorNickname() {
		return deductorNickname;
	}
	public void setDeductorNickname(String deductorNickname) {
		this.deductorNickname = deductorNickname;
	}
	public TDSCertificate[] getTDSCertificates() {
		return TDSCertificates;
	}
	public void setTDSCertificates(TDSCertificate[] tDSCertificates) {
		this.TDSCertificates = tDSCertificates;
	}
	
	@JsonIgnore public double getTotalDeductions(){
		double deductions = 0;
		
		if ( TDSCertificates == null )
			return deductions;
		
		for ( int i = 0; i < TDSCertificates.length; i++){
			deductions = deductions + TDSCertificates[i].getDeduction();
		}
	
		return deductions;
	}
	
	public TaxDeductor(	String TAN,
		String deductorName,
		String deductorNickname
			){
		setDeductorName(deductorName);
		setDeductorNickname(deductorNickname);
		setTAN(TAN);
	}
	
	public TaxDeductor(){
		TAN = "";
		deductorName = "";
		deductorNickname = "";
	}
	
	public String toString(){
		return this.getClass().getName() + " TAN:" + TAN + " deductorName:" + deductorName 
				+ " deductorNickname:" + deductorNickname + " TDS Certificates:" + TDSCertificates;
	}
	
	public boolean equals(TaxDeductor deductor){
		boolean retVal = true;
		
		if (deductor == null)
			return false;

		
		if (deductor.deductorName != this.deductorName)
			return false;
		
		if (deductor.TAN != this.TAN)
			return false;
		
		if (deductor.TDSCertificates != null && this.TDSCertificates != null){
			if (deductor.TDSCertificates.length != this.TDSCertificates.length)
				return false;
			else{
				for (int i=0; i< this.TDSCertificates.length; i++){
					if (!this.TDSCertificates[i].equals(deductor.TDSCertificates[i])){
						retVal = false;
						break;
					}
				}
				
			}
			
		}else if(deductor.TDSCertificates == null && this.TDSCertificates == null){
			return true;
		}else{
			return false;
		}
		
		return retVal;
	}
}
