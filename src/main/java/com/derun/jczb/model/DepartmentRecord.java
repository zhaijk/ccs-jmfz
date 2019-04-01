package com.derun.jczb.model;

public class DepartmentRecord {
	
	private Long rn;
	private String departmentName;
	private String oilName;
	private String guidelineName;
	private String credenceNumber;
	private int oilType;
	private String departmentCode;
	private String provideDate;
	private String provideTime;
	private double inputGuideline;
	private int guidelineType;
	private String confirmPerson;
	private String log;
	private String operator;
	private int tflag;

	public String getConfirmPerson() {
		return confirmPerson;
	}

	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
	}

	public String getCredenceNumber() {
		return credenceNumber;
	}

	public void setCredenceNumber(String credenceNumber) {
		this.credenceNumber = credenceNumber;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getGuidelineType() {
		return guidelineType;
	}

	public void setGuidelineType(int guidelineType) {
		this.guidelineType = guidelineType;
	}

	public double getInputGuideline() {
		return inputGuideline;
	}

	public void setInputGuideline(double inputGuideline) {
		this.inputGuideline = inputGuideline;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public int getOilType() {
		return oilType;
	}

	public void setOilType(int oilType) {
		this.oilType = oilType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getProvideDate() {
		return provideDate;
	}

	public void setProvideDate(String provideDate) {
		this.provideDate = provideDate;
	}

	public String getProvideTime() {
		return provideTime;
	}

	public void setProvideTime(String provideTime) {
		this.provideTime = provideTime;
	}

	public int getTflag() {
		return tflag;
	}

	public void setTflag(int tflag) {
		this.tflag = tflag;
	}

	public String getGuidelineName() {
		return guidelineName;
	}

	public void setGuidelineName(String guidelineName) {
		this.guidelineName = guidelineName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}
	
	public Long getRn() {
		return rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}
}
