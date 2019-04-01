package com.derun.util;

import java.time.LocalDate;

//import java.util.BitSet;

//import java.util.BitSet;

public class DataTypeConverter {

	public static String d2s(double data) {
		return String.format("%.2f", data);
	}
	public static Double d2d(double data) {
		return Double.parseDouble(String.format("%.2f", data));
	}
	public static String getDate() {
		return LocalDate.now().toString();
	}
	public static String getYear() {
		return String.valueOf(LocalDate.now().getYear());
	}
	public static int getIntYear() {
		return LocalDate.now().getYear();
	}
//	public static void main(String[] args) {
//		//String str=getDate();
//		System.out.println(getDate()+getYear());
//	}
	/*public static void main(String[] args) {
		BitSet  bs=new BitSet(32);
		bs.set(1, 32, true);
		byte[] data=bs.toByteArray();
		System.out.println(data.length);
		System.out.println(String.format("%02X %02X %02X %02X ", data[0],data[1],data[2],data[3]));
		bs.set(1, 32, false);
		data=bs.toByteArray();
		System.out.println(data.length);
		System.out.println(String.format("%02X %02X %02X %02X ", data[0],data[1],data[2],data[3]));
		
	}*/
}
