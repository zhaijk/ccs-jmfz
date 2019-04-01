package com.derun.jczb.model;

import java.util.Date;

public class Logmsg {

	private Long logmsgid;//换牌日志编号
	private String cardcode;//卡号
	private String oldvin;//旧车牌
	private String newvin;//新车牌
	private Date logdate;//日志生成时间
	
	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public Date getLogdate() {
		return logdate;
	}

	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}

	public Long getLogmsgid() {
		return logmsgid;
	}

	public void setLogmsgid(Long logmsgid) {
		this.logmsgid = logmsgid;
	}

	public String getNewvin() {
		return newvin;
	}

	public void setNewvin(String newvin) {
		this.newvin = newvin;
	}

	public String getOldvin() {
		return oldvin;
	}

	public void setOldvin(String oldvin) {
		this.oldvin = oldvin;
	}

}