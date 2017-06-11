package com.taxapp.datapackets;

import com.taxapp.enums.CommunicationsModuleType;
import com.taxapp.enums.ResponseType;

public class ResponsePacket extends CommunicationsPacket{
	
	private ResponseType responseType;
	private String failureReason;
	
	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	public ResponsePacket(){
		super();
		super.module = CommunicationsModuleType.Response;
	}
}
