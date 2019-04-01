package com.derun.jczb.model;

public class OilInfo{
	
	private long id;
	private String name;
	private String departmentCode;
	private int oilType;
	private double density;

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getOilType() {
		return oilType;
	}

	public void setOilType(int oilType) {
		this.oilType = oilType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
