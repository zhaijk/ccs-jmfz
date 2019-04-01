package com.derun.jczb.model;


public class Viewdiaobodanrecord {

	private int id;					// id
	private String danjuhao;		// 单据号
	private String kaidanriqi;		// 开单日期
	private String shougongdanwei;	// 受供单位
	private int niandu;				// 年度
	private double shiwu;			// 实物
	private double jiabo;			// 价拨;
	private String youpincode;		// 油品
	private int leixing;			// 类型
	private String beizhu;
	private Long cishu;				// 调拨次数 2014.2.17新加的字段
	private String cishues;

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getDanjuhao() {
		return danjuhao;
	}

	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getJiabo() {
		return jiabo;
	}

	public void setJiabo(double jiabo) {
		this.jiabo = jiabo;
	}

	public String getKaidanriqi() {
		return kaidanriqi;
	}

	public void setKaidanriqi(String kaidanriqi) {
		this.kaidanriqi = kaidanriqi;
	}

	public int getLeixing() {
		return leixing;
	}

	public void setLeixing(int leixing) {
		this.leixing = leixing;
	}

	public int getNiandu() {
		return niandu;
	}

	public void setNiandu(int niandu) {
		this.niandu = niandu;
	}

	public double getShiwu() {
		return shiwu;
	}

	public void setShiwu(double shiwu) {
		this.shiwu = shiwu;
	}

	public String getShougongdanwei() {
		return shougongdanwei;
	}

	public void setShougongdanwei(String shougongdanwei) {
		this.shougongdanwei = shougongdanwei;
	}

	public String getYoupincode() {
		return youpincode;
	}

	public void setYoupincode(String youpincode) {
		this.youpincode = youpincode;
	}

	public Long getCishu() {
		return cishu;
	}

	public void setCishu(Long cishu) {
		this.cishu = cishu;
	}

	public String getCishues() {
		return cishues;
	}

	public void setCishues(String cishues) {
		this.cishues = cishues;
	}

}
