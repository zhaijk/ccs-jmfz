package com.derun.jczb.model;

public class CarTypeDictionary {
	private long id;
	private int autoCarType2;
	private String name;	
	private String departmentCode;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getAutoCarType2() {
		return autoCarType2;
	}

	public void setAutoCarType2(int autoCarType2) {
		this.autoCarType2 = autoCarType2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
