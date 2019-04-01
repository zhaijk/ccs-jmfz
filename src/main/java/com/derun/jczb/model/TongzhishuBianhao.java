package com.derun.jczb.model;

public class TongzhishuBianhao {
	
	private Long id;  
	private String leixing;	//通知书类型
	private String bianhao;	//编号
	private Integer niandu;  //年度 
	
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public Integer getNiandu() {
		return niandu;
	}
	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}
	
}
