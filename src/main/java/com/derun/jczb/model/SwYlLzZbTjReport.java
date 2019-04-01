package com.derun.jczb.model;

public class SwYlLzZbTjReport {
	
	private String recorddate;
	private Double sqjz;
	private Double shouru;
	private Double zhichu;
	private Double jiechun;
	
	public Double getJiechun() {
		return jiechun;
	}
	public void setJiechun(Double jiechun) {
		this.jiechun = jiechun;
	}
	public String getRecorddate() {
		return recorddate;
	}
	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}
	public Double getSqjz() {
		return sqjz;
	}
	public void setSqjz(Double sqjz) {
		this.sqjz = sqjz;
	}
	public Double getShouru() {
		return shouru;
	}
	public void setShouru(Double shouru) {
		this.shouru = shouru;
	}
	public Double getZhichu() {
		return zhichu;
	}
	public void setZhichu(Double zhichu) {
		this.zhichu = zhichu;
	}	
	@Override
	public String toString() {
		return "SwYlLzZbTjReport [recorddate=" + recorddate + ", sqjz=" + sqjz + ", shouru=" + shouru + ", zhichu="
				+ zhichu + ", jiechun=" + jiechun + "]";
	}	
}
