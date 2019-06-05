package com.derun.ccs.jmfz.controller;

import java.util.List;

public class DataTableDO<T> {
	private String action;
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
