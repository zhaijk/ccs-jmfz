package com.derun.jczb.dao;

import java.util.List;

public class TotalDTO {
	
	private List<Double> objs;
	private double total;
	private double change;
	private double balance;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<Double> getObjs() {
		return objs;
	}
	public void setObjs(List<Double> objs) {
		this.objs = objs;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
