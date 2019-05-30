package com.derun.jczb.model;

public class DepartmentIncome {
	
	private int id;
	private String incomID;
	private String departmentCode;
	private int oilType;
	private double tonNum;
	private double inputGuideline2;
	private String provideDate2;
	private double density;
	private int incomType;			//1:上级调拨  2:支队自购 	
	private int coverType;	
	private String danjuhao;
	private String oilName;
	
	public String getDanjuhao() {		
		return danjuhao;
	}

	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}

	public int getCoverType() {
		return coverType;
	}

	public void setCoverType(int coverType) {
		this.coverType = coverType;
	}

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

	public String getIncomID() {
		return incomID;
	}

	public void setIncomID(String incomID) {
		this.incomID = incomID;
	}

	public int getIncomType() {
		return incomType;
	}

	public void setIncomType(int incomType) {
		this.incomType = incomType;
	}

	public double getInputGuideline2() {
		return inputGuideline2;
	}

	public void setInputGuideline2(double inputGuideline2) {
		this.inputGuideline2 = inputGuideline2;
	}

	public int getOilType() {
		return oilType;
	}

	public void setOilType(int oilType) {
		this.oilType = oilType;
	}

	public String getProvideDate2() {
		return provideDate2;
	}

	public void setProvideDate2(String provideDate2) {
		this.provideDate2 = provideDate2;
	}

	public double getTonNum() {
		return tonNum;
	}

	public void setTonNum(double tonNum) {
		this.tonNum = tonNum;
	}

	@Override
	public String toString() {
		return "DepartmentIncome [incomID=" + incomID + ", departmentCode=" + departmentCode + ", oilType=" + oilType
				+ ", tonNum=" + tonNum + ", inputGuideline2=" + inputGuideline2 + ", provideDate2=" + provideDate2
				+ ", density=" + density + ", incomType=" + incomType + ", coverType=" + coverType + ", danjuhao="
				+ danjuhao + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}	
}
