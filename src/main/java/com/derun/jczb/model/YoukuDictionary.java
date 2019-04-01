package com.derun.jczb.model;

public class YoukuDictionary{
	
	private int id;
	private String youku_code;	// 油库编码,主键,四位 = 两位总队编码+生成两位的油库编码
	private String youku;		// 油库名称
	private Long leixing;		// 类型 1为解放军油库2为武警油库
	private Long flag;			// 标记 0可删1 2不可删

//	public YoukuDictionary() {
//	}
//
//	public YoukuDictionary(String youkuCode) {
//		this.youkuCode = youkuCode;
//	}
//
//	public YoukuDictionary(String youkuCode, String youku, Long leixing,
//			Long flag) {
//		this.youkuCode = youkuCode;
//		this.youku = youku;
//		this.leixing = leixing;
//		this.flag = flag;
//	}
	public String getYouku() {
		return this.youku;
	}

	public void setYouku(String youku) {
		this.youku = youku;
	}

	public Long getLeixing() {
		return this.leixing;
	}

	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}

	public Long getFlag() {
		return this.flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getYouku_code() {
		return youku_code;
	}

	public void setYouku_code(String youku_code) {
		this.youku_code = youku_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}