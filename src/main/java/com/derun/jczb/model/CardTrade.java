package com.derun.jczb.model;

public class CardTrade {
	
	private long rn;
	private String carcode;
	private String cardtypename;
	private String oiltypeName;
	private String owner;
	private String guidelinecount;	
	private String guncode;	
	private String cardstatus;	
	private String stationname;	
	private String departmentname;
	
	private Long id;
	private String cardcode;
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

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
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

	public String getOiltypeName() {
		return oiltypeName;
	}

	public void setOiltypeName(String oiltypeName) {
		this.oiltypeName = oiltypeName;
	}	

	public String getCarcode() {
		return carcode;
	}

	public void setCarcode(String carcode) {
		this.carcode = carcode;
	}

	public long getRn() {
		return rn;
	}

	public void setRn(long rn) {
		this.rn = rn;
	}

	public String getCardtypename() {
		return cardtypename;
	}

	public void setCardtypename(String cardtypename) {
		this.cardtypename = cardtypename;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getGuncode() {
		return guncode;
	}

	public void setGuncode(String guncode) {
		this.guncode = guncode;
	}	

	public String getGuidelinecount() {
		return guidelinecount;
	}

	public void setGuidelinecount(String guidelinecount) {
		this.guidelinecount = guidelinecount;
	}

	public String getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getStationname() {
		return stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	@Override
	public String toString() {
		return "CardTrade [rn=" + rn + ", carcode=" + carcode + ", cardtypename=" + cardtypename + ", oiltypeName="
				+ oiltypeName + ", owner=" + owner + ", guidelinecount=" + guidelinecount + ", guncode=" + guncode
				+ ", cardstatus=" + cardstatus + ", stationname=" + stationname + ", departmentname=" + departmentname
				+ ", id=" + id + ", cardcode=" + cardcode + ", tradedate=" + tradedate + ", tradetime=" + tradetime
				+ ", tradetype=" + tradetype + ", stationid=" + stationid + ", recno=" + recno + ", autoCarCode="
				+ autoCarCode + ", oiltype=" + oiltype + ", volumn=" + volumn + ", mileage=" + mileage + ", balance="
				+ balance + ", sendflag=" + sendflag + ", account=" + account + ", operator=" + operator + ", tflag="
				+ tflag + ", shougongdanweiid=" + shougongdanweiid + ", zhugongdanweiid=" + zhugongdanweiid
				+ ", jiaoyijine=" + jiaoyijine + ", sign=" + sign + ", cardType=" + cardType + ", volumnt=" + volumnt
				+ ", remark=" + remark + ", ifchongdi=" + ifchongdi + "]";
	}
}
