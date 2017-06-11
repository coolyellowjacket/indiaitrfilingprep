package com.taxapp.enums;

public enum NoticeType {
	Unknown(-1,"Unknown"),
	NoNotice(1,"NoNotice"),
	Notice142_1(2,"Notice 142(1)"),
	Notice148(3,"Notice 148"),
	Notice153A(4,"Notice 153A"),
	Notice153C(5,"Notice 153C"),
	Notice139_5(6,"Notice 139(5)"),
	Notice139_9(7,"Notice 139(9)");
	
	public final int value;
	public final String name;
	
	NoticeType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
