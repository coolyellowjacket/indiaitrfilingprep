package com.taxapp.networkops;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxapp.datapackets.CommunicationsPacket;
import com.taxapp.datapackets.LoginData;
import com.taxapp.datapackets.ResponsePacket;

public class NetworkConnector {
	public NetworkConnector(){
		
	}
	
	protected String createJsonData(CommunicationsPacket dataObject){
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
			mapper.writeValue(byteStream, dataObject);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonData = byteStream.toString();
		return jsonData;
	}

		
	protected ResponsePacket retrieveJsonData(byte[] data){
		ResponsePacket responsePacket = new ResponsePacket();
		ObjectMapper mapper = new ObjectMapper();
		try {
			responsePacket = mapper.readValue(data, ResponsePacket.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responsePacket;
	}
	
	protected String createJsonData(LoginData dataObject){
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
			mapper.writeValue(byteStream, dataObject);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonData = byteStream.toString();
		return jsonData;
	}


}
