package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.model.CarInfo;
import com.derun.jczb.model.DepartmentInfo;

@Controller
public class DepartManager {

	private Logger logger=LoggerFactory.getLogger(DepartManager.class);
	
	@Autowired 
	private DepartmentInfoMapper departmentInfoMapper;
	    
	@GetMapping("depart-manager.htm")
	public String init(ModelMap model) {
		//Cookie cookie=session.getCookie();
		//部门信息
		model.put("departInfos",departmentInfoMapper.queryALL());	
	
		return "depart_manager";
	}
	@GetMapping("depart-manager/datas")
	@ResponseBody
	public DataTableDO<DepartmentInfo> datas() {		
		DataTableDO<DepartmentInfo> dataTableDO=new DataTableDO<DepartmentInfo>();
		dataTableDO.setData(departmentInfoMapper.queryALL());
		return dataTableDO;
	}
	@PostMapping("depart-manager/edit")
	@ResponseBody
	public String update(String action,CarInfo obj) {		
		logger.debug(action+"--"+obj);
		int result=0;
		switch(action) {
		case "update":
			result=departmentInfoMapper.updateOne(obj);
			break;			
		case "insert":
			result=departmentInfoMapper.insertOne(obj);
			break;
		case "delete":
			result=departmentInfoMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
