package com.derun.jczb.model;

import java.util.List;

public class DepartmentProvideInfo {

	private String departmentName;
	private String departmentCode;
	private List<Double> oiltypeSum;
	private List<Double> fixedProvide;
	private List<Double> fafangValue;
	private int  flag;
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Double> getOiltypeSum() {
		return oiltypeSum;
	}
	public void setOiltypeSum(List<Double> oiltypeSum) {
		this.oiltypeSum = oiltypeSum;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public List<Double> getFixedProvide() {
		return fixedProvide;
	}
	public void setFixedProvide(List<Double> fixedProvide) {
		this.fixedProvide = fixedProvide;
	}
	public List<Double> getFafangValue() {
		return fafangValue;
	}
	public void setFafangValue(List<Double> fafangValue) {
		this.fafangValue = fafangValue;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}	
}
