package com.derun.jczb.model;

/**
 * 		各部门上报车辆明细表实体类
*    
* 项目名称：dao   
* 类名称：Iccard20130507_2View   
* 类描述：   
* 创建人：--> 肖俊   
* 创建时间：2013-5-7 下午05:10:03   
* 修改人：Administrator   
* 修改时间：2013-5-7 下午05:10:03   
* 修改备注：   
* @version    V1.0
*
 */
public class Iccard20130507_2View {

	private String areaCode;//大部门编码	
	private String areaName;//大部门名称	
	private String departmentCode;//部门编码	
	private String autocarCode;//车牌号	
	private String carBrand;   //品牌	
	private String driverName; //使用人
	private String note2;     //备注

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAutocarCode() {
		return autocarCode;
	}

	public void setAutocarCode(String autocarCode) {
		this.autocarCode = autocarCode;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}
	
	
}
