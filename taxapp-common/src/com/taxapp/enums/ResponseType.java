package com.taxapp.enums;

public enum ResponseType {
	Success(1,"Success"),
	Failure(0,"Failure"),
	LoginCredentialsFailure(-1,"LoginCredentialsFailure"),							//Incorrect username, password
	LoginFailureInternalError(-2,"LoginFailureInternalError"), 						//Internal error causing login failure
	LoginRepeatedCredentialsFailure(-3,"LoginRepeatedCredentialsFailure"),			//Repeated incorrect username, password
	DBWriteFailure(-4, "DBWriteError"),												//DB Write error
	DBReadFailure(-5, "DBReadError"),												//DB Read error
	SessionExpired(-6,"SessionExpired");
	
	public final int value;
	public final String name;
	
	ResponseType(int value, String name){
		this.value = value;
		this.name = name;
	}
}
