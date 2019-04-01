package com.derun.jczb.model;

public class CardWhite {
	
	private String cardCode;
	private String beginDate;
	private String operator;
	private String owner;
	private String bumen;	
	private String autocarcode;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAutocarcode() {
		return autocarcode;
	}

	public void setAutocarcode(String autocarcode) {
		this.autocarcode = autocarcode;
	}

}
