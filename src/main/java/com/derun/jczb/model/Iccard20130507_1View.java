package com.derun.jczb.model;

/**
 * 		查询部门卡基本信息
*    
* 项目名称：dao   
* 类名称：Iccard20130507_1View   
* 类描述：   
* 创建人：--> 肖俊   
* 创建时间：2013-5-7 下午03:23:04   
* 修改人：Administrator   
* 修改时间：2013-5-7 下午03:23:04   
* 修改备注：   
* @version    V1.0
*
 */
public class Iccard20130507_1View {

	private String dbmCode;//大部门编码	
	private String dmCode;//部门编码	
	private String cpm;//车牌号	
	private String cardCode;//卡号	
	private String oiltype;//油品	
	private String gdzb;//固定指标	
	private String cardstatus;//卡状态	
	private String jkdate;//建卡日期	
	private String owner;//备注	
	private String cardtype;//卡类型	
	private String memo;//挂失原因	
	private String operator;//使用人	
	private String loseDate;//挂失日期
	
	public String getLoseDate() {
		return loseDate;
	}

	public void setLoseDate(String loseDate) {
		this.loseDate = loseDate;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}

	public String getCpm() {
		return cpm;
	}

	public void setCpm(String cpm) {
		this.cpm = cpm;
	}

	public String getDbmCode() {
		return dbmCode;
	}

	public void setDbmCode(String dbmCode) {
		this.dbmCode = dbmCode;
	}

	public String getDmCode() {
		return dmCode;
	}

	public void setDmCode(String dmCode) {
		this.dmCode = dmCode;
	}

	public String getGdzb() {
		return gdzb;
	}

	public void setGdzb(String gdzb) {
		this.gdzb = gdzb;
	}

	public String getJkdate() {
		return jkdate;
	}

	public void setJkdate(String jkdate) {
		this.jkdate = jkdate;
	}

	public String getOiltype() {
		return oiltype;
	}

	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
