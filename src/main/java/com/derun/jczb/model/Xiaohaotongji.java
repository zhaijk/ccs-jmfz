package com.derun.jczb.model;

import java.math.BigDecimal;

public class Xiaohaotongji{

	private Long xhtjId;
	private String danweicode;
	private Long niandu;
	private Long jidu;
	private Long youbianhao;
	private Double sjxiaoji=0.0;
	private Double sjzhugong=0.0;
	private Double sjzigou=0.0;
	private Double sjjiabo=0.0;
	private Double srxiaoji=0.0;
	private Double srshiwuzhugong=0.0;
	private Double srshiwuzigou=0.0;
	private Double srjiabo=0.0;
	private Double zcshiwuxiaoji=0.0;
	private Double zcshiwuzhugongbx=0.0;
	private Double zcshiwuzhugongtx=0.0;
	private Double zcshiwuzhugongsh=0.0;
	private Double zcshiwuzigouxh=0.0;
	private Double zcshiwuzigoush=0.0;
	private Double zcjiaboxh=0.0;
	private Double zcjiabosh=0.0;
	private Double zcheji=0.0;
	private Double bjxiaoji=0.0;
	private Double bjzhugong=0.0;
	private Double bjzigou=0.0;
	private Double bjjiaobo=0.0;
	private String zbdanwei;
	private long id;	
	private String oliName;	
	private String updatetime;// 上传时间
	
	
//	// Constructors
//
//	/** default constructor */
//	public Xiaohaotongji() {
//	}
//
//	/** minimal constructor */
//	public Xiaohaotongji(Long xhtjId, String danweicode, Long jidu) {
//		this.xhtjId = xhtjId;
//		this.danweicode = danweicode;
//		this.jidu = jidu;
//	}
//
//	/** full constructor */
//	public Xiaohaotongji(Long xhtjId, String danweicode, Long niandu,
//			Long jidu, Long youbianhao, Double sjxiaoji, Double sjzhugong,
//			Double sjzigou, Double sjjiabo, Double srxiaoji,
//			Double srshiwuzhugong, Double srshiwuzigou, Double srjiabo,
//			Double zcshiwuxiaoji, Double zcshiwuzhugongbx,
//			Double zcshiwuzhugongtx, Double zcshiwuzhugongsh,
//			Double zcshiwuzigouxh, Double zcshiwuzigoush, Double zcjiaboxh,
//			Double zcjiabosh, Double zcheji, Double bjxiaoji, Double bjzhugong,
//			Double bjzigou, Double bjjiaobo, String zbdanwei) {
//		this.xhtjId = xhtjId;
//		this.danweicode = danweicode;
//		this.niandu = niandu;
//		this.jidu = jidu;
//		this.youbianhao = youbianhao;
//		this.sjxiaoji = sjxiaoji;
//		this.sjzhugong = sjzhugong;
//		this.sjzigou = sjzigou;
//		this.sjjiabo = sjjiabo;
//		this.srxiaoji = srxiaoji;
//		this.srshiwuzhugong = srshiwuzhugong;
//		this.srshiwuzigou = srshiwuzigou;
//		this.srjiabo = srjiabo;
//		this.zcshiwuxiaoji = zcshiwuxiaoji;
//		this.zcshiwuzhugongbx = zcshiwuzhugongbx;
//		this.zcshiwuzhugongtx = zcshiwuzhugongtx;
//		this.zcshiwuzhugongsh = zcshiwuzhugongsh;
//		this.zcshiwuzigouxh = zcshiwuzigouxh;
//		this.zcshiwuzigoush = zcshiwuzigoush;
//		this.zcjiaboxh = zcjiaboxh;
//		this.zcjiabosh = zcjiabosh;
//		this.zcheji = zcheji;
//		this.bjxiaoji = bjxiaoji;
//		this.bjzhugong = bjzhugong;
//		this.bjzigou = bjzigou;
//		this.bjjiaobo = bjjiaobo;
//		this.zbdanwei = zbdanwei;
//	}
//
//	// Property accessors

	public Long getXhtjId() {
		return this.xhtjId;
	}

	public void setXhtjId(Long xhtjId) {
		this.xhtjId = xhtjId;
	}

	public String getDanweicode() {
		return this.danweicode;
	}

	public void setDanweicode(String danweicode) {
		this.danweicode = danweicode;
	}

	public Long getNiandu() {
		return this.niandu;
	}

	public void setNiandu(Long niandu) {
		this.niandu = niandu;
	}

	public Long getJidu() {
		return this.jidu;
	}

	public void setJidu(Long jidu) {
		this.jidu = jidu;
	}

	public Long getYoubianhao() {
		return this.youbianhao;
	}

	public void setYoubianhao(Long youbianhao) {
		this.youbianhao = youbianhao;
	}

	public Double getSjxiaoji() {
		
		return new   BigDecimal(this.sjxiaoji).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setSjxiaoji(Double sjxiaoji) {
		this.sjxiaoji = sjxiaoji;
	}

	public Double getSjzhugong() {
		return new   BigDecimal(this.sjzhugong).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.sjzhugong;
	}

	public void setSjzhugong(Double sjzhugong) {
		this.sjzhugong = sjzhugong;
	}

	public Double getSjzigou() {
		return new   BigDecimal(this.sjzigou).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.sjzigou;
	}

	public void setSjzigou(Double sjzigou) {
		this.sjzigou = sjzigou;
	}

	public Double getSjjiabo() {
		return new   BigDecimal(this.sjjiabo).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.sjjiabo;
	}

	public void setSjjiabo(Double sjjiabo) {
		this.sjjiabo = sjjiabo;
	}

	public Double getSrxiaoji() {
		return new   BigDecimal(this.srxiaoji).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.srxiaoji;
	}

	public void setSrxiaoji(Double srxiaoji) {
		this.srxiaoji = srxiaoji;
	}

	public Double getSrshiwuzhugong() {
		return new   BigDecimal(this.srshiwuzhugong).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.srshiwuzhugong;
	}

	public void setSrshiwuzhugong(Double srshiwuzhugong) {
		this.srshiwuzhugong = srshiwuzhugong;
	}

	public Double getSrshiwuzigou() {
		return new   BigDecimal(this.srshiwuzigou).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.srshiwuzigou;
	}

	public void setSrshiwuzigou(Double srshiwuzigou) {
		this.srshiwuzigou = srshiwuzigou;
	}

	public Double getSrjiabo() {
		return new   BigDecimal(this.srjiabo).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.srjiabo;
	}

	public void setSrjiabo(Double srjiabo) {
		this.srjiabo = srjiabo;
	}

	public Double getZcshiwuxiaoji() {
		return new   BigDecimal(this.zcshiwuxiaoji).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuxiaoji;
	}

	public void setZcshiwuxiaoji(Double zcshiwuxiaoji) {
		this.zcshiwuxiaoji = zcshiwuxiaoji;
	}

	public Double getZcshiwuzhugongbx() {
		return new   BigDecimal(this.zcshiwuzhugongbx).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuzhugongbx;
	}

	public void setZcshiwuzhugongbx(Double zcshiwuzhugongbx) {
		this.zcshiwuzhugongbx = zcshiwuzhugongbx;
	}

	public Double getZcshiwuzhugongtx() {
		return new   BigDecimal(this.zcshiwuzhugongtx).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuzhugongtx;
	}

	public void setZcshiwuzhugongtx(Double zcshiwuzhugongtx) {
		this.zcshiwuzhugongtx = zcshiwuzhugongtx;
	}

	public Double getZcshiwuzhugongsh() {
		return new   BigDecimal(this.zcshiwuzhugongsh).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuzhugongsh;
	}

	public void setZcshiwuzhugongsh(Double zcshiwuzhugongsh) {
		this.zcshiwuzhugongsh = zcshiwuzhugongsh;
	}

	public Double getZcshiwuzigouxh() {
		return new   BigDecimal(this.zcshiwuzigouxh).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuzigouxh;
	}

	public void setZcshiwuzigouxh(Double zcshiwuzigouxh) {
		this.zcshiwuzigouxh = zcshiwuzigouxh;
	}

	public Double getZcshiwuzigoush() {
		return new   BigDecimal(this.zcshiwuzigoush).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcshiwuzigoush;
	}

	public void setZcshiwuzigoush(Double zcshiwuzigoush) {
		this.zcshiwuzigoush = zcshiwuzigoush;
	}

	public Double getZcjiaboxh() {
		return new   BigDecimal(this.zcjiaboxh).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcjiaboxh;
	}

	public void setZcjiaboxh(Double zcjiaboxh) {
		this.zcjiaboxh = zcjiaboxh;
	}

	public Double getZcjiabosh() {
		return new   BigDecimal(this.zcjiabosh).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcjiabosh;
	}

	public void setZcjiabosh(Double zcjiabosh) {
		this.zcjiabosh = zcjiabosh;
	}

	public Double getZcheji() {
		return new   BigDecimal(this.zcheji).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.zcheji;
	}

	public void setZcheji(Double zcheji) {
		this.zcheji = zcheji;
	}

	public Double getBjxiaoji() {
		return new   BigDecimal(this.bjxiaoji).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.bjxiaoji;
	}

	public void setBjxiaoji(Double bjxiaoji) {
		this.bjxiaoji = bjxiaoji;
	}

	public Double getBjzhugong() {
		return new   BigDecimal(this.bjzhugong).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.bjzhugong;
	}

	public void setBjzhugong(Double bjzhugong) {
		this.bjzhugong = bjzhugong;
	}

	public Double getBjzigou() {
		return new   BigDecimal(this.bjzigou).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.bjzigou;
	}

	public void setBjzigou(Double bjzigou) {
		this.bjzigou = bjzigou;
	}

	public Double getBjjiaobo() {
		return new   BigDecimal(this.bjjiaobo).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		//return this.bjjiaobo;
	}

	public void setBjjiaobo(Double bjjiaobo) {
		this.bjjiaobo = bjjiaobo;
	}

	public String getZbdanwei() {
		return this.zbdanwei;
	}

	public void setZbdanwei(String zbdanwei) {
		this.zbdanwei = zbdanwei;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOliName() {
		return oliName;
	}

	public void setOliName(String oliName) {
		this.oliName = oliName;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}	
}