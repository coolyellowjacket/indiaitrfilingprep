package com.taxapp.dataops;

import org.apache.log4j.Logger;

import com.taxapp.datapackets.ResponsePacket;
import com.taxapp.datapackets.SalaryIncomeData;
import com.taxapp.datapackets.UserSessionInfo;
import com.taxapp.enums.CommunicationsModuleType;
import com.taxapp.enums.ResponseType;
import com.taxapp.networkops.DataConnector;
import com.taxapp.networkops.NetworkAuthentication;

public class DataOps {
	
	static Logger logger;
	
	/**
	 * Processes login to the application and returns a UserSessionInfo object upon successfull
	 * authentication. Any error is logged into the logger.
	 * 
	 * @param username
	 * @param password
	 * @return a UserSessionInfo object upon successful login. Returns null otherwise.
	 */
	public UserSessionInfo processLogin(String username, String password) {
		UserSessionInfo userSessionInfo = null;
		if(username == null || password == null)
			return userSessionInfo;
		
		if(username.trim() == "" || password.trim() == "")
			return userSessionInfo;
				
		NetworkAuthentication netAuth = new NetworkAuthentication(username, password);
		if ( netAuth.isSuccessfulLogin() ){
			userSessionInfo = netAuth.retrieveUserSession();
		}else{
			logger.error("Invalid username or password");
			userSessionInfo = null;
		}

		return userSessionInfo;
	}
	
	/**
	 * Writes SalaryIncomeData object to database for a given UserSessionInfo object. Only one SalaryIncomeData object is 
	 * associated with a single user. Error is written into the logger object
	 * 
	 * @param salaryIncomeData
	 * @param userSessionInfo
	 * @return true upon successful save, false upon unsuccessful save operation. 
	 */
	public static boolean saveSalaryData(SalaryIncomeData salaryIncomeData, UserSessionInfo userSessionInfo){
		boolean status = false;
		if(salaryIncomeData == null || userSessionInfo == null)
			return status;
					
		status = processDataConnection(userSessionInfo, CommunicationsModuleType.SalaryIncome, salaryIncomeData);		
		return status;
	}
	
	private static boolean processDataConnection(UserSessionInfo userInfo, CommunicationsModuleType commModuleType, Object data){
		DataConnector dataConnector = new DataConnector();
		ResponsePacket response = (ResponsePacket) dataConnector.processRequest(commModuleType, data, userInfo);

		if(response.getResponseType().equals(ResponseType.SessionExpired)){
			logger.error("Session Expired");
			return false;
		}else if(!response.getResponseType().equals(ResponseType.Success)){
			String error = response.getFailureReason();
			logger.error(error);
			return false;
		}
		
		return true;
	}
	
	public DataOps(Logger logger){
		if(logger == null)
			logger = Logger.getLogger("Default Logger. Its better to pass down a logger created externally");
		this.logger = logger;
	}
	
	/**
	 * Use this to get details about error message due to any of the data operations in this class. 
	 * 
	 * @return the logger.
	 */
	public Logger getLogger(){
		return logger;
	}

}
