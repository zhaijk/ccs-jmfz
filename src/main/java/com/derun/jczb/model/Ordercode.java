package com.derun.jczb.model;

public class Ordercode {

	private String key;// 主键
	private String value;// 值

	public Ordercode() {
	}

	public Ordercode(String key) {
		this.key = key;
	}

	public Ordercode(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}