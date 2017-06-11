package com.taxapp.networkops;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import com.taxapp.enums.CommunicationsModuleType;
import com.taxapp.utils.JSONUtils;
import com.taxapp.datapackets.CommunicationsPacket;
import com.taxapp.datapackets.LoginData;
import com.taxapp.datapackets.ResponsePacket;
import com.taxapp.datapackets.UserSessionInfo;
import com.taxapp.enums.ResponseType;
import com.taxapp.utils.NetworkUtils;

public class NetworkAuthentication extends NetworkConnector{

	final String serverUrl = "http://x8-burnished-fold-6.appspot.com/lowlevelappserver";
	final String requestUrl = serverUrl + "/process";

	ResponsePacket responsePacket;
	
	public NetworkAuthentication(String username, String password){
		sendData(username, password);
	}
	
	public boolean isSuccessfulLogin(){
		if ( this.responsePacket.getResponseType() == ResponseType.Success )
			return true;
		else
			return false;
	}
	
	public UserSessionInfo retrieveUserSession(){
		return JSONUtils.decodeUserSessionJSON( this.responsePacket.getJsonData() );
	}
	
	private void sendData(String username, String password){
		CommunicationsPacket commPacket = NetworkUtils.createCommunicationsPacket(CommunicationsModuleType.Login);
		commPacket.setIsWrite( 0 );
		LoginData loginData = createLoginData(username, password);
		String jsonLoginData = createJsonData(loginData);
		commPacket.setJsonData(jsonLoginData);
		String jsonData = createJsonData(commPacket);
		HttpPost httpPost = NetworkUtils.createNetworkData(jsonData, requestUrl);
		HttpResponse httpResponse = NetworkUtils.sendRequest(httpPost);
		byte[] responseBuf = NetworkUtils.processResponse(httpResponse);
		if(responseBuf != null)
			this.responsePacket = retrieveJsonData(responseBuf);
		else{
			this.responsePacket = new ResponsePacket();
			responsePacket.setResponseType(ResponseType.Failure);
		}
	}
	
	private LoginData createLoginData(String username, String password){
		LoginData loginPacket = new LoginData();
		loginPacket.setUsername(username);
		loginPacket.setPassword(password);
		return loginPacket;
	}	
	
}
