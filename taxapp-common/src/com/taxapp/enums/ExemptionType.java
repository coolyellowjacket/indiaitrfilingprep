package com.taxapp.enums;

public enum ExemptionType {
	Exemption80C(1,"80C"),
	Exemption80CCC(2,"80CCC"),
	Exemption80CCD(3,"80CCCD"),
	Exemption80CCF(4,"80CCF"),
	Exemption80CCG(5,"80CCG"),
	Exemption80D(6,"80D"),
	Exemption80DD(7,"80DD"),
	Exemption80DDB(8,"80DDB"),
	Exemption80E(9,"80DDB"),
	Exemption80G(10,"80G"),
	Exemption80GG(11,"80GG"),
	Exemption80GGA(12,"80GGA"),
	Exemption80GGC(13,"80GGC"),
	Exemption80U(14,"80U"),
	Exemption80RRB(15,"80RRB"),
	Exemption80QQB(16,"80QQB"),
	Exemption80IA(17,"80IA"),
	Exemption80IAB(18,"80IAB"),
	Exemption80IB(19,"80IB"),
	Exemption80IC(20,"80IC"),
	Exemption80ID(21,"80ID"),
	Exemption80JJA(22,"80JJA"),
	ExemptionTTA(23,"80TTA"),
	Unknown(-1,"Unknown");
	
	public final int value;
	public final String name;
	ExemptionType(int value, String name){
		this.value = value;
		this.name = name;
	}

}
