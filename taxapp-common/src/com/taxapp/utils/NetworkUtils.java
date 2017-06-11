package com.taxapp.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.taxapp.datapackets.CommunicationsPacket;
import com.taxapp.enums.CommunicationsModuleType;

public final class NetworkUtils {
	
	public static final HttpPost createNetworkData(String jsonData, String url){
    	HttpPost httpPost = new HttpPost(url);
    	httpPost.setHeader("Content-type", "application/json");
    	try {
			httpPost.setEntity(new StringEntity(jsonData));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return httpPost;
	}
	
	public static final HttpResponse sendRequest(HttpPost httpPost){
    	DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponse;
	}
	
	public static final byte[] sendRequest(String jsonString, String requestUrl){
		ByteArrayOutputStream output = null;
		try{
		    URL url = new URL(requestUrl);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    
		    System.setProperty("http.keepAlive", "false");
		    conn.setDoOutput(true);
		    conn.setRequestMethod("POST");
		    conn.setChunkedStreamingMode(0);
	
		    OutputStream out = conn.getOutputStream();
		    out.write(jsonString.getBytes());
		    
		    InputStream in = new BufferedInputStream(conn.getInputStream());
		    
		    byte[] buffer = new byte[8192];
		    int bytesRead;
		    output = new ByteArrayOutputStream();
		    while ((bytesRead = in.read(buffer)) != -1)
		    {
		        output.write(buffer, 0, bytesRead);
		    }    
		    
		    out.close();
		    in.close();
		    conn.disconnect();

		}
		catch(IOException e){
			e.printStackTrace();
		}

		if(output == null)
			return null;
		else
			return output.toByteArray();
	}
	
	public static final byte[] processResponse(HttpResponse httpResponse){
		HttpEntity responseEntity = httpResponse.getEntity();
		InputStream in;
		byte[] inBuf = new byte[9999];
		try {
			in = responseEntity.getContent();
			in.read(inBuf);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inBuf;
	}

	public static CommunicationsPacket createCommunicationsPacket(CommunicationsModuleType moduleType){
		CommunicationsPacket commPacket = new CommunicationsPacket();
		commPacket.setModule(moduleType);
		return commPacket;
	}

}
