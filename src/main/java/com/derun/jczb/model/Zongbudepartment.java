package com.derun.jczb.model;


public class Zongbudepartment {
	
	private Long id;		//主键
	private String code;	//单位编码
	private String name;	//单位名称
	private Long flag;		//标志
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
