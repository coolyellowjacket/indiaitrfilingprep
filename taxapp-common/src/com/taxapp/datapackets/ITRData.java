package com.taxapp.datapackets;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapp.enums.BankAccountType;
import com.taxapp.enums.DisabilityType;
import com.taxapp.enums.EmployeeType;
import com.taxapp.enums.FilingTiming;
import com.taxapp.enums.Gender;
import com.taxapp.enums.ITRType;
import com.taxapp.enums.NetTaxType;
import com.taxapp.enums.NoticeType;
import com.taxapp.enums.RefundOrPaymentType;
import com.taxapp.enums.ResidentType;
import com.taxapp.utils.UpdateDetails;

public class ITRData {
	
	Logger log;

	//Derived fields
	UserSessionInfo userSessionInfo;			//User info from UserMaster
	UpdateDetails updateDetails;
	ITRType itrType;		
	int age;					//Derive from userInformation

	//User input fields
	String nickName;			//Default should be anincrementing number of the ITRs the user has created so far
	int assessmentYear;			//"Assesment year being filed for
								//If 2013-2014 then 2013"		
	EmployeeType employeeType;	//Enum:Others, PSU, Govt, NA	
	int hasDependentParents;	
	int numDependentChildren;
	DisabilityType disabilityType;
	NetTaxType netTaxStatus;	 		

	String bankAccountNum;				
	String MICRCode;				
	BankAccountType bankAccountType;				//Enum: Current Account, Savings account		
	String IFSCCode;
	RefundOrPaymentType refundOrPaymentType;		//Enum: Cheque, Direct Deposit	

	FilingTiming filingTiming;	//User only inputs if the filing is revised. 
	String origReturnReceiptNum;//if revised return is filed then required		
	Date origReturnReceiptDate;	//if revised return is filed then required		
	NoticeType noticeTypeforResponse;
	
	int isDefective = 0;		//"Default Value 0
								//0 :: Not Defective
								//1 :: Defective
								//If a return is filed after the due date and is incorrect it is considered defective"
	String defectiveNoticeNum;	//Notice Number
	Date defectiveNoticeDate;	//Notice Date
	
	
	ITRClassificationData itrClassificationData;
	TaxData taxData;
	
	@JsonIgnore public String portugeseCodeApplies(){
		return "N";
	}
	
	@JsonIgnore public String getReturnType(){
		if (getFilingTiming() == FilingTiming.Unknown){
			log.log(Level.SEVERE, "FilingTiming is unknown for userSession:");
			return null;
		}
			
		if (getFilingTiming() == FilingTiming.Revised)
			return "O";
		else
			return "R";
	}
	
	@JsonIgnore public String getResidentialStatus(){
		if (itrClassificationData == null){
			log.log(Level.SEVERE, "ITR Classification is null for userSession:");
			return null;
		}
		
		if (itrClassificationData.residentType == ResidentType.Resident)
			return "RES";
		if (itrClassificationData.residentType == ResidentType.NRI)
			return "NRI";
		if (itrClassificationData.residentType == ResidentType.NotOrdinaryResident)
			return "NOR";

		return null;
	}

	public UserSessionInfo getUserSessionInfo() {
		return userSessionInfo;
	}
	public void setUserSessionInfo(UserSessionInfo userSessionInfo) {
		this.userSessionInfo = userSessionInfo;
	}
	public UpdateDetails getUpdateDetails() {
		return updateDetails;
	}
	public void setUpdateDetails(UpdateDetails updateDetails) {
		this.updateDetails = updateDetails;
	}
	public ITRType getItrType() {
		return itrType;
	}
	public void setItrType(ITRType itrType) {
		this.itrType = itrType;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAssessmentYear() {
		return assessmentYear;
	}
	public void setAssessmentYear(int assessmentYear) {
		this.assessmentYear = assessmentYear;
	}
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	public int getHasDependentParents() {
		return hasDependentParents;
	}
	public void setHasDependentParents(int hasDependentParents) {
		this.hasDependentParents = hasDependentParents;
	}
	public int getNumDependentChildren() {
		return numDependentChildren;
	}
	public void setNumDependentChildren(int numDependentChildren) {
		this.numDependentChildren = numDependentChildren;
	}
	public DisabilityType getDisabilityType() {
		return disabilityType;
	}
	public void setDisabilityType(DisabilityType disabilityType) {
		this.disabilityType = disabilityType;
	}
	public NetTaxType getNetTaxStatus() {
		return netTaxStatus;
	}
	public void setNetTaxStatus(NetTaxType netTaxStatus) {
		this.netTaxStatus = netTaxStatus;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}
	public String getMICRCode() {
		return MICRCode;
	}
	public void setMICRCode(String mICRCode) {
		MICRCode = mICRCode;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}
	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	public RefundOrPaymentType getRefundOrPaymentType() {
		return refundOrPaymentType;
	}
	public void setRefundOrPaymentType(RefundOrPaymentType refundOrPaymentType) {
		this.refundOrPaymentType = refundOrPaymentType;
	}
	public FilingTiming getFilingTiming() {
		return filingTiming;
	}
	public void setFilingTiming(FilingTiming filingTiming) {
		this.filingTiming = filingTiming;
	}
	public String getOrigReturnReceiptNum() {
		return origReturnReceiptNum;
	}
	public void setOrigReturnReceiptNum(String origReturnReceiptNum) {
		this.origReturnReceiptNum = origReturnReceiptNum;
	}
	public Date getOrigReturnReceiptDate() {
		return origReturnReceiptDate;
	}
	public void setOrigReturnReceiptDate(Date origReturnReceiptDate) {
		this.origReturnReceiptDate = origReturnReceiptDate;
	}
	public NoticeType getNoticeTypeforResponse() {
		return noticeTypeforResponse;
	}
	public void setNoticeTypeforResponse(NoticeType noticeTypeforResponse) {
		this.noticeTypeforResponse = noticeTypeforResponse;
	}
	public int getIsDefective() {
		return isDefective;
	}
	public void setIsDefective(int isDefective) {
		this.isDefective = isDefective;
	}
	public String getDefectiveNoticeNum() {
		return defectiveNoticeNum;
	}
	public void setDefectiveNoticeNum(String defectiveNoticeNum) {
		this.defectiveNoticeNum = defectiveNoticeNum;
	}
	public Date getDefectiveNoticeDate() {
		return defectiveNoticeDate;
	}
	public void setDefectiveNoticeDate(Date defectiveNoticeDate) {
		this.defectiveNoticeDate = defectiveNoticeDate;
	}
	public ITRClassificationData getItrClassificationData() {
		return itrClassificationData;
	}
	public void setItrClassificationData(ITRClassificationData itrClassificationData) {
		this.itrClassificationData = itrClassificationData;
	}
	public TaxData getTaxData() {
		return taxData;
	}
	public void setTaxData(TaxData taxData) {
		this.taxData = taxData;
	}
	public int isValid(){
		//Offshore: checks if data in the packet is valid prior to a db write
		return 1;
	}
	public ITRData(){	
	    log = Logger.getLogger(ITRData.class.getName());
	}
}
