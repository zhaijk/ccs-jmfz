package com.derun.jczb.model;

public class NidiaobodanRecord {

	private Long id;	
	private Long youpincode;		//油品	
	private double shiwu = 0d; 		//实物	
	private double jiabo = 0d; 		//价拨	
	private Nidiaobodan nidiaobodan;//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getJiabo() {
		return jiabo;
	}

	public void setJiabo(double jiabo) {
		this.jiabo = jiabo;
	}

	public double getShiwu() {
		return shiwu;
	}

	public void setShiwu(double shiwu) {
		this.shiwu = shiwu;
	}

	public Nidiaobodan getNidiaobodan() {
		return nidiaobodan;
	}

	public void setNidiaobodan(Nidiaobodan nidiaobodan) {
		this.nidiaobodan = nidiaobodan;
	}

	public Long getYoupincode() {
		return youpincode;
	}

	public void setYoupincode(Long youpincode) {
		this.youpincode = youpincode;
	}
}
