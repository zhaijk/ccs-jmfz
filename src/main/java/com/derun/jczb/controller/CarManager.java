package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CarInfoMapper;
import com.derun.jczb.dao.CarTypeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.model.CarInfo;

@Controller
public class CarManager {

	private Logger logger=LoggerFactory.getLogger(CarManager.class);
	
	@Autowired 
	private CarInfoMapper carInfoMapper;
	@Autowired 
    private DepartmentInfoMapper departmentInfoMapper;
    @Autowired 
    private CarTypeMapper carTypeMapper;
    
	@GetMapping("car-manager.htm")
	public String init(ModelMap model) {
		//Cookie cookie=session.getCookie();
		//车类型
		model.put("carTypeInfos",carTypeMapper.queryALL());	
		//部门
		model.put("departInfos",departmentInfoMapper.queryALL());	
		model.put("carInfos",carInfoMapper.queryALLUnions());		
		return "car_manager";
	}
	@GetMapping("car-manager/datas")
	@ResponseBody
	public DataTableDO<CarInfo> datas() {		
		DataTableDO<CarInfo> dataTableDO=new DataTableDO<CarInfo>();
		dataTableDO.setData(carInfoMapper.queryALLUnions());
		return dataTableDO;
	}
	@PostMapping("car-manager/edit")
	@ResponseBody
	public String update(String action,CarInfo obj) {		
		logger.debug(action+"--"+obj);
		int result=0;
		switch(action) {
		case "update":
			result=carInfoMapper.updateOne(obj);
			break;			
		case "insert":
			result=carInfoMapper.insertOne(obj);
			break;
		case "delete":
			result=carInfoMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
