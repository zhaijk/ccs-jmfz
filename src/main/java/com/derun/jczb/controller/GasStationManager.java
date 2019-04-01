package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

//import com.derun.jczb.dao.CarInfoMapper;
//import com.derun.jczb.dao.CarTypeMapper;
//import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.GasStationMapper;
import com.derun.jczb.model.CarInfo;
import com.derun.jczb.model.Jiayouzhan;

@Controller
public class GasStationManager {

	private Logger logger=LoggerFactory.getLogger(GasStationManager.class);
	
	@Autowired 
	private GasStationMapper gasStationMapper;
	    
	@GetMapping("gas-station-manager.htm")
	public String init(ModelMap model) {
		/*//Cookie cookie=session.getCookie();
		//车类型
		model.put("carTypeInfos",gasStationMapper.queryALL());	
		//部门
		model.put("departInfos",departmentInfoMapper.queryALL());	
		model.put("carInfos",carInfoMapper.queryALLUnions());*/	
		//model.put("gasStationInfos",gasStationMapper.queryALL());	
		return "gas_station_manager";
	}
	@GetMapping("gas-station-manager/datas")
	@ResponseBody
	public DataTableDO<Jiayouzhan> datas() {		
		DataTableDO<Jiayouzhan> dataTableDO=new DataTableDO<Jiayouzhan>();
		dataTableDO.setData(gasStationMapper.queryALL());
		return dataTableDO;
	}
	@PostMapping("gas-station-manager/edit")
	@ResponseBody
	public String update(String action,CarInfo obj) {		
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
