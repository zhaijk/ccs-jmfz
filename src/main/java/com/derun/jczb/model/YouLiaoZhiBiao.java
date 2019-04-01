package com.derun.jczb.model;

import java.util.List;

public class YouLiaoZhiBiao {
	private int id;

	private String name;

	private int oilType;

	private double volumn=0.0;

	private List<ZhiBiaoOil> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ZhiBiaoOil> getList() {
		return list;
	}

	public void setList(List<ZhiBiaoOil> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOilType() {
		return oilType;
	}

	public void setOilType(int oilType) {
		this.oilType = oilType;
	}

	public double getVolumn() {
		return volumn;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
}
