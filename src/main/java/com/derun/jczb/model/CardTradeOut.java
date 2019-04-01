package com.derun.jczb.model;


public class CardTradeOut {

	private Long id;
	private String cordcode;
	private String tradedate;
	private String tradetime;
	private Long tradetype;
	private String stationid;
	private Long recno;
	private String autoCarCode;
	private Long oiltype;
	private Double volumn;
	private Long mileage;
	private Double balance;
	private Long sendflag;
	private Long account;
	private String operator;
	private Long tflag;
	private String shougongdanweiid;
	private String zhugongdanweiid;
	private Double jiaoyijine;
	private String sign;	
	private long cardType = 0;	
	private double volumnt = 0.0;	
	private String remark;	
	private double ifchongdi;
	

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getAutoCarCode() {
		return autoCarCode;
	}

	public void setAutoCarCode(String autoCarCode) {
		this.autoCarCode = autoCarCode;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public long getCardType() {
		return cardType;
	}

	public void setCardType(long cardType) {
		this.cardType = cardType;
	}

	public String getCordcode() {
		return cordcode;
	}

	public void setCordcode(String cordcode) {
		this.cordcode = cordcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getIfchongdi() {
		return ifchongdi;
	}

	public void setIfchongdi(double ifchongdi) {
		this.ifchongdi = ifchongdi;
	}

	public Double getJiaoyijine() {
		return jiaoyijine;
	}

	public void setJiaoyijine(Double jiaoyijine) {
		this.jiaoyijine = jiaoyijine;
	}

	public Long getMileage() {
		return mileage;
	}

	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}

	public Long getOiltype() {
		return oiltype;
	}

	public void setOiltype(Long oiltype) {
		this.oiltype = oiltype;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getRecno() {
		return recno;
	}

	public void setRecno(Long recno) {
		this.recno = recno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSendflag() {
		return sendflag;
	}

	public void setSendflag(Long sendflag) {
		this.sendflag = sendflag;
	}

	public String getShougongdanweiid() {
		return shougongdanweiid;
	}

	public void setShougongdanweiid(String shougongdanweiid) {
		this.shougongdanweiid = shougongdanweiid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getStationid() {
		return stationid;
	}

	public void setStationid(String stationid) {
		this.stationid = stationid;
	}

	public Long getTflag() {
		return tflag;
	}

	public void setTflag(Long tflag) {
		this.tflag = tflag;
	}

	public String getTradedate() {
		return tradedate;
	}

	public void setTradedate(String tradedate) {
		this.tradedate = tradedate;
	}

	public String getTradetime() {
		return tradetime;
	}

	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}

	public Long getTradetype() {
		return tradetype;
	}

	public void setTradetype(Long tradetype) {
		this.tradetype = tradetype;
	}

	public Double getVolumn() {
		return volumn;
	}

	public void setVolumn(Double volumn) {
		this.volumn = volumn;
	}

	public double getVolumnt() {
		return volumnt;
	}

	public void setVolumnt(double volumnt) {
		this.volumnt = volumnt;
	}

	public String getZhugongdanweiid() {
		return zhugongdanweiid;
	}

	public void setZhugongdanweiid(String zhugongdanweiid) {
		this.zhugongdanweiid = zhugongdanweiid;
	}
 

}