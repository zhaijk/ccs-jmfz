package com.derun.jczb.model;

import java.util.Date;

public class CardMain {
	
	private long  id;
	private String cardcode;
	private String stationID;
	private String autoCarCode;	
	private String employee;
	private int oilType;
	private String cardPassword;
	private double storageCount=0.0;
	private double cardCount;
	private double noOperateCount;
	private double destineGuideline;
	private double carLimit;
	private int guidelinetype;
	private int fillFlag;
	private String cardstatus;
	private String editDate;
	private String buildDate;
	private String fillCardCode;
	private String fillCardterm;
	private String operator;
	private String owner;
	private String phone;
	private String memo;
	private double subsidyTotal;
	private double subsidyOnce;
	private double subsidyAllow;
	private String subsidyReason;
	private String subsidyType;
	private int tflag;
	private int cardType;	
	private Integer carCard;//是否为车卡识别卡
	private String departmentCode;	
	private String departmentname;	
	private double buzhuzhibiao;//补助指标	
	private String buzhuDate;//补助过期时间	
	private double maxcount;//卡最大限额	
	private Date bufadate;	
	private String loseDate;	
	private String reuseDate;	
	private double mileage;//消费次数


	public Date getBufadate() {
		return bufadate;
	}

	public void setBufadate(Date bufadate) {
		this.bufadate = bufadate;
	}

	public String getBuzhuDate() {
		return buzhuDate;
	}

	public double getMaxcount() {
		return maxcount;
	}

	public void setMaxcount(double maxcount) {
		this.maxcount = maxcount;
	}

	public void setBuzhuDate(String buzhuDate) {
		this.buzhuDate = buzhuDate;
	}

	public double getBuzhuzhibiao() {
		return buzhuzhibiao;
	}

	public void setBuzhuzhibiao(double buzhuzhibiao) {
		this.buzhuzhibiao = buzhuzhibiao;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getAutoCarCode() {
		return autoCarCode;
	}

	public void setAutoCarCode(String autoCarCode) {
		this.autoCarCode = autoCarCode;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public double getCardCount() {
		return cardCount;
	}

	public void setCardCount(double cardCount) {
		this.cardCount = cardCount;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public double getCarLimit() {
		return carLimit;
	}

	public void setCarLimit(double carLimit) {
		this.carLimit = carLimit;
	}

	public double getDestineGuideline() {
		return destineGuideline;
	}

	public void setDestineGuideline(double destineGuideline) {
		this.destineGuideline = destineGuideline;
	}

	public String getFillCardCode() {
		return fillCardCode;
	}

	public void setFillCardCode(String fillCardCode) {
		this.fillCardCode = fillCardCode;
	}

	public String getFillCardterm() {
		return fillCardterm;
	}

	public void setFillCardterm(String fillCardterm) {
		this.fillCardterm = fillCardterm;
	}

	public int getFillFlag() {
		return fillFlag;
	}

	public void setFillFlag(int fillFlag) {
		this.fillFlag = fillFlag;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public double getNoOperateCount() {
		return noOperateCount;
	}

	public void setNoOperateCount(double noOperateCount) {
		this.noOperateCount = noOperateCount;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}

	public double getStorageCount() {
		return storageCount;
	}

	public void setStorageCount(double storageCount) {
		this.storageCount = storageCount;
	}

	public double getSubsidyAllow() {
		return subsidyAllow;
	}

	public void setSubsidyAllow(double subsidyAllow) {
		this.subsidyAllow = subsidyAllow;
	}

	public double getSubsidyOnce() {
		return subsidyOnce;
	}

	public void setSubsidyOnce(double subsidyOnce) {
		this.subsidyOnce = subsidyOnce;
	}

	public String getSubsidyReason() {
		return subsidyReason;
	}

	public void setSubsidyReason(String subsidyReason) {
		this.subsidyReason = subsidyReason;
	}

	public double getSubsidyTotal() {
		return subsidyTotal;
	}

	public void setSubsidyTotal(double subsidyTotal) {
		this.subsidyTotal = subsidyTotal;
	}

	public String getSubsidyType() {
		return subsidyType;
	}

	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	}

	public int getTflag() {
		return tflag;
	}

	public void setTflag(int tflag) {
		this.tflag = tflag;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public Integer getCarCard() {
		return carCard;
	}

	public void setCarCard(Integer carCard) {
		this.carCard = carCard;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getLoseDate() {
		return loseDate;
	}

	public void setLoseDate(String loseDate) {
		this.loseDate = loseDate;
	}

	public String getReuseDate() {
		return reuseDate;
	}

	public void setReuseDate(String reuseDate) {
		this.reuseDate = reuseDate;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public int getGuidelinetype() {
		return guidelinetype;
	}

	public void setGuidelinetype(int guidelinetype) {
		this.guidelinetype = guidelinetype;
	}

	public String getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
