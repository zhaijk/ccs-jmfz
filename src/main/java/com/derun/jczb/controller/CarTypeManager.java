package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.jczb.dao.CarTypeMapper;
import com.derun.jczb.model.CarTypeDictionary;

@Controller
public class CarTypeManager {

	private Logger logger=LoggerFactory.getLogger(CarTypeManager.class);
		
    @Autowired 
    private CarTypeMapper carTypeMapper;
    
	@GetMapping("car-type-manager.htm")
	public String init(ModelMap model) {
		//Cookie cookie=session.getCookie();
		//车类型
		model.put("carTypeInfos",carTypeMapper.queryALL());
		return "car_type_manager";
	}
	@GetMapping("car-type-manager/datas")
	@ResponseBody
	public DataTableDO<CarTypeDictionary> datas() {		
		DataTableDO<CarTypeDictionary> dataTableDO=new DataTableDO<CarTypeDictionary>();
		dataTableDO.setData(carTypeMapper.queryALL());
		return dataTableDO;
	}	
	@PostMapping("car-type-manager/edit")
	@ResponseBody
	public String update(String action,CarTypeDictionary obj) {		
		logger.debug(action+"--"+obj);
		int result=0;
		switch(action) {
		case "update":
			//result=carInfoMapper.updateOne(obj);
			break;			
		case "insert":
			//result=carInfoMapper.insertOne(obj);
			break;
		case "delete":
			//result=carInfoMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
