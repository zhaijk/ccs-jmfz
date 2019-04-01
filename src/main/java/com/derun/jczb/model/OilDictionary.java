package com.derun.jczb.model;

public class OilDictionary {
	
	private Long id;		//主键,序列生成
	private Long code;		// 油品编码
	private String name;	// 油品名称
	private Double density;	// 油品密度(决策不用)
	private Long flag;		// 0未使用可删除1已使用不能删除2已下载不能删除

//	public OilDictionary() {
//	}
//
//	public OilDictionary(Long id, Long code, String name, Double density,
//			Long flag) {
//		this.id = id;
//		this.code = code;
//		this.name = name;
//		this.density = density;
//		this.flag = flag;
//	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDensity() {
		return this.density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Long getFlag() {
		return this.flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

}