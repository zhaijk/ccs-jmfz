package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.jczb.dao.CarInfoMapper;
import com.derun.jczb.dao.CarTypeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.model.CarInfo;

@Controller
public class CardTradeQuery {

	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(CardTradeQuery.class);
	
	@Autowired 
	private CarInfoMapper carInfoMapper;
	@Autowired 
    private DepartmentInfoMapper departmentInfoMapper;
    @Autowired 
    private CarTypeMapper carTypeMapper;
    
	@GetMapping("card-trade-query.htm")
	public String init(ModelMap model) {
		//Cookie cookie=session.getCookie();
		//车类型
		model.put("carTypeInfos",carTypeMapper.queryALL());	
		//部门
		model.put("departInfos",departmentInfoMapper.queryALL());	
		model.put("carInfos",carInfoMapper.queryALLUnions());		
		return "car_manager";
	}
	@GetMapping("card-trade-query/datas")
	@ResponseBody
	public DataTableDO<CarInfo> datas() {		
		DataTableDO<CarInfo> dataTableDO=new DataTableDO<CarInfo>();
		dataTableDO.setData(carInfoMapper.queryALLUnions());
		return dataTableDO;
	}	
}
