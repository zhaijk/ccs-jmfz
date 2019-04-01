package com.derun.jczb.model;

public class CarInfo {
	
	private Long id;
	private String autoCarCode;
	private int passportName;
	private int autoCarColor2;
	private int autoCarType2;
	private String carIdentify;	
	private String carBrand;
	private String driverName;	
	private String departmentCode;
	private String telephoneNumber;
	private String passportNumber;
	private String fastDate;
	private String operator;
	private int tflag;
	private String note2;
	private int counter;
	private String carBrandName;
	private String departmentName;
	private String name;
	
	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getAutoCarCode() {
		return autoCarCode;
	}

	public void setAutoCarCode(String autoCarCode) {
		this.autoCarCode = autoCarCode;
	}

	public String getCarIdentify() {
		return carIdentify;
	}

	public void setCarIdentify(String carIdentify) {
		this.carIdentify = carIdentify;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getFastDate() {
		return fastDate;
	}

	public void setFastDate(String fastDate) {
		this.fastDate = fastDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public int getTflag() {
		return tflag;
	}

	public void setTflag(int tflag) {
		this.tflag = tflag;
	}

	public int getAutoCarColor2() {
		return autoCarColor2;
	}

	public void setAutoCarColor2(int autoCarColor2) {
		this.autoCarColor2 = autoCarColor2;
	}

	public int getAutoCarType2() {
		return autoCarType2;
	}

	public void setAutoCarType2(int autoCarType2) {
		this.autoCarType2 = autoCarType2;
	}

	public int getPassportName() {
		return passportName;
	}

	public void setPassportName(int passportName) {
		this.passportName = passportName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CarInfo [id=" + id + ", autoCarCode=" + autoCarCode + ", passportName=" + passportName
				+ ", autoCarColor2=" + autoCarColor2 + ", autoCarType2=" + autoCarType2 + ", carIdentify=" + carIdentify
				+ ", carBrand=" + carBrand + ", driverName=" + driverName + ", departmentCode=" + departmentCode
				+ ", telephoneNumber=" + telephoneNumber + ", passportNumber=" + passportNumber + ", fastDate="
				+ fastDate + ", operator=" + operator + ", tflag=" + tflag + ", note2=" + note2 + ", counter=" + counter
				+ ", carBrandName=" + carBrandName + ", name=" + name + ", departmentName=" + departmentName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
