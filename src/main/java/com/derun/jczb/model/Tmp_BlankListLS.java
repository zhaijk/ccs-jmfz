package com.derun.jczb.model;

public class Tmp_BlankListLS {

	private String cardCode;//卡号	
	private Integer cardBiaoZhi; //标志,0.挂失,1.取消挂失	
	private String datetime; //挂失时间

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getCardBiaoZhi() {
		return cardBiaoZhi;
	}

	public void setCardBiaoZhi(Integer cardBiaoZhi) {
		this.cardBiaoZhi = cardBiaoZhi;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
}
