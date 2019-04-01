package com.derun.jczb.dao;

import java.util.List;

public class OperatorDTO<T> {
	
	private String action;
	private List<T> data;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
