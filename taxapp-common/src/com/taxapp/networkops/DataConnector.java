package com.taxapp.networkops;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;


import com.taxapp.utils.JSONUtils;
import com.taxapp.datapackets.AllData;
import com.taxapp.datapackets.CommunicationsPacket;
import com.taxapp.datapackets.ResponsePacket;
import com.taxapp.datapackets.UserSessionInfo;
import com.taxapp.enums.CommunicationsModuleType;
import com.taxapp.enums.ResponseType;
import com.taxapp.utils.NetworkUtils;

public class DataConnector extends NetworkConnector{
	final String serverUrl = "http://x8-burnished-fold-6.appspot.com/lowlevelappserver";
	final String requestUrl = serverUrl + "/process";
	
	public DataConnector(){
		
	}
	
	public Object retrieveObject(CommunicationsModuleType moduleType, UserSessionInfo userSessionInfo){
		switch(moduleType){
			case DividendIncome:
				String jsonDividendIncomeData = getJsonResponse(CommunicationsModuleType.DividendIncome, userSessionInfo);
				return JSONUtils.decodeDividendIncomeJSON(jsonDividendIncomeData);
			case AgricultureIncome:
				String jsonAgriIncomeData = getJsonResponse(CommunicationsModuleType.AgricultureIncome, userSessionInfo);
				return JSONUtils.decodeAgricultureIncomeJSON(jsonAgriIncomeData);
			case MachineryIncome:
				String jsonMachineryIncomeData = getJsonResponse(CommunicationsModuleType.MachineryIncome, userSessionInfo);
				return JSONUtils.decodeMachineryIncomeJSON(jsonMachineryIncomeData);
			case TaxExemptMinorIncome:
				String jsonMinorIncomeData = getJsonResponse(CommunicationsModuleType.TaxExemptMinorIncome, userSessionInfo);
				return JSONUtils.decodeTaxExemptMinorIncomeJSON(jsonMinorIncomeData);
			case GiftIncome:
				String jsonGiftIncomeData = getJsonResponse(CommunicationsModuleType.GiftIncome, userSessionInfo);
				return JSONUtils.decodeGiftIncomeJSON(jsonGiftIncomeData);
			case InterestIncome:
				String jsonInterestIncomeData = getJsonResponse(CommunicationsModuleType.InterestIncome, userSessionInfo);
				return JSONUtils.decodeInterestIncomeJSON(jsonInterestIncomeData);
			case RentalIncome:
				String jsonRentalIncomeData = getJsonResponse(CommunicationsModuleType.RentalIncome, userSessionInfo);
				return JSONUtils.decodeRentalIncomeDataJSON(jsonRentalIncomeData);
			case SalaryIncome:
				String jsonIncomeData = getJsonResponse(CommunicationsModuleType.SalaryIncome, userSessionInfo);
				return JSONUtils.decodeSalaryIncomeDataJSON(jsonIncomeData);
			case ITRClassification:
				String jsonITRClassificationDate = getJsonResponse(CommunicationsModuleType.ITRClassification, userSessionInfo);
				return JSONUtils.decodeITRClassificationJSON(jsonITRClassificationDate);
			case ITRData:
				String jsonITRData = getJsonResponse(CommunicationsModuleType.ITRData, userSessionInfo);
				return JSONUtils.decodeITRDataJSON(jsonITRData);
			case Exemptions:
				String jsonExemptionData = getJsonResponse(CommunicationsModuleType.Exemptions, userSessionInfo);
				return JSONUtils.decodeExemptionJSON(jsonExemptionData);
			case Payments:
				String jsonPaymentsData = getJsonResponse(CommunicationsModuleType.Payments, userSessionInfo);
				return JSONUtils.decodePaymentsJSON(jsonPaymentsData);
			case AllData:
				String jsonAllData = getJsonResponse(CommunicationsModuleType.AllData, userSessionInfo);
				return JSONUtils.decodeAllDataJSON(jsonAllData);
			default:
				return null;
		}
	}
	
	public Object processRequest(CommunicationsModuleType moduleType, Object dataPacket, UserSessionInfo userSessionInfo){
		String inputJsonData = "";
		ResponsePacket response;
		
		switch(moduleType){
			case ITRClassification:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.ITRClassification, inputJsonData, userSessionInfo);
				return response;
			case SalaryIncome:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.SalaryIncome, inputJsonData, userSessionInfo);
				return response;
			case EmailXML:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.EmailXML, inputJsonData, userSessionInfo);
				return response;
			case Registration:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.Registration, inputJsonData);
				return response;
			case UserDetails:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.UserDetails, inputJsonData, userSessionInfo);
				return response;
			case Exemptions:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.Exemptions, inputJsonData, userSessionInfo);
				return response;
			case ITRData:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.ITRData, inputJsonData, userSessionInfo);
				return response;
			case TaxReport:
				inputJsonData = JSONUtils.encodeToJSON(dataPacket);
				response = getResponse(CommunicationsModuleType.TaxReport, inputJsonData, userSessionInfo);
				return response;
            case Payments:
                inputJsonData = JSONUtils.encodeToJSON(dataPacket);
                response = getResponse(CommunicationsModuleType.Payments, inputJsonData, userSessionInfo);
                return response;
            default:
				return null;
		}
	}

	private String getJsonResponse(CommunicationsModuleType moduleType, UserSessionInfo userSessionInfo){
		CommunicationsPacket commPacket = NetworkUtils.createCommunicationsPacket(moduleType);
		commPacket.setIsWrite(0);
		commPacket.setJsonData(null);
		commPacket.setUserSessionInfo(userSessionInfo);
		String jsonData = JSONUtils.encodeToJSON(commPacket);
	    byte[] responseBuf = NetworkUtils.sendRequest(jsonData, requestUrl);
		ResponsePacket responsePacket = retrieveJsonData(responseBuf);
		return responsePacket.getJsonData();
	}
	
	private ResponsePacket getResponse(CommunicationsModuleType moduleType, String inputJsonData){
		ResponsePacket responsePacket = null;
		CommunicationsPacket commPacket = NetworkUtils.createCommunicationsPacket(moduleType);
		commPacket.setIsWrite(1);
		commPacket.setJsonData(inputJsonData);
		String jsonData = JSONUtils.encodeToJSON(commPacket);
		byte[] responseBuf = NetworkUtils.sendRequest(jsonData, requestUrl);
		if(responseBuf != null)
			responsePacket = retrieveJsonData(responseBuf);
		else{
			responsePacket = new ResponsePacket();
			responsePacket.setResponseType(ResponseType.Failure);
		}
		return responsePacket;
	}

	private ResponsePacket getResponse(CommunicationsModuleType moduleType,
			String inputJsonData, UserSessionInfo userSessionInfo) {
		ResponsePacket responsePacket = null;
		CommunicationsPacket commPacket = NetworkUtils.createCommunicationsPacket(moduleType);
		commPacket.setIsWrite(1);
		commPacket.setJsonData(inputJsonData);
		commPacket.setUserSessionInfo(userSessionInfo);
		String jsonData = JSONUtils.encodeToJSON(commPacket);
		byte[] responseBuf = NetworkUtils.sendRequest(jsonData, requestUrl);
		if(responseBuf != null)
			responsePacket = retrieveJsonData(responseBuf);
		else{
			responsePacket = new ResponsePacket();
			responsePacket.setResponseType(ResponseType.Failure);
		}
		return responsePacket;
	}

}
