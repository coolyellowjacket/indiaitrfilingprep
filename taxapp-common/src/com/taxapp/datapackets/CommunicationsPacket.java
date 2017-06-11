package com.taxapp.datapackets;

import com.taxapp.enums.CommunicationsModuleType;
import com.taxapp.enums.ScreenType;

public class CommunicationsPacket {

	public UserSessionInfo getUserSessionInfo() {
		return userSessionInfo;
	}
	public void setUserSessionInfo(UserSessionInfo userSessionInfo) {
		this.userSessionInfo = userSessionInfo;
	}
	public CommunicationsModuleType getModule() {
		return module;
	}
	public void setModule(CommunicationsModuleType module) {
		this.module = module;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public ScreenType getScreenType() {
		return screenType;
	}
	public void setScreenType(ScreenType screenType) {
		this.screenType = screenType;
	}
	public int getIsWrite() {
		return isWrite;
	}
	public void setIsWrite(int isWrite) {
		this.isWrite = isWrite;
	}

	UserSessionInfo userSessionInfo;
	CommunicationsModuleType module;
	ScreenType screenType;
	String jsonData;
	int isWrite;

}
