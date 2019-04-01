package com.derun.jczb.model;

public class OilTankInfo {

	private Integer uti_ID;		//油罐ID	
	private String stationId;	//油罐编码	
	private Double oilTankId;	//油罐ID	
	private String stationName;	//油罐名称	
	private Integer oilCode;	//油品编码	
	private Double cyrl;	
	private Double cyl;	
	private Double grl;	
	private Double yrj;	
	private Double yw;	
	private Double sw;	
	private Double wd;	
	private Double yqld;	
	private String collectdate;	//采集日期
	private String collecttime;//采集时间

	public Double getCyl() {
		return cyl;
	}

	public void setCyl(Double cyl) {
		this.cyl = cyl;
	}

	public Double getCyrl() {
		return cyrl;
	}

	public void setCyrl(Double cyrl) {
		this.cyrl = cyrl;
	}

	public Double getGrl() {
		return grl;
	}

	public void setGrl(Double grl) {
		this.grl = grl;
	}

	public Integer getOilCode() {
		return oilCode;
	}

	public void setOilCode(Integer oilCode) {
		this.oilCode = oilCode;
	}

	public Double getOilTankId() {
		return oilTankId;
	}

	public void setOilTankId(Double oilTankId) {
		this.oilTankId = oilTankId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Double getSw() {
		return sw;
	}

	public void setSw(Double sw) {
		this.sw = sw;
	}

	public Integer getUti_ID() {
		return uti_ID;
	}

	public void setUti_ID(Integer uti_ID) {
		this.uti_ID = uti_ID;
	}

	public Double getWd() {
		return wd;
	}

	public void setWd(Double wd) {
		this.wd = wd;
	}

	public Double getYqld() {
		return yqld;
	}

	public void setYqld(Double yqld) {
		this.yqld = yqld;
	}

	public Double getYrj() {
		return yrj;
	}

	public void setYrj(Double yrj) {
		this.yrj = yrj;
	}

	public Double getYw() {
		return yw;
	}

	public void setYw(Double yw) {
		this.yw = yw;
	}

	public String getCollectdate() {
		return collectdate;
	}

	public void setCollectdate(String collectdate) {
		this.collectdate = collectdate;
	}

	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	
}
