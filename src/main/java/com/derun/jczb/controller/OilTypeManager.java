package com.derun.jczb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.OilInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class OilTypeManager {

	private Logger logger=LoggerFactory.getLogger(OilTypeManager.class);
		
    @Autowired 
    private OilInfoMapper oilInfoMapper;
    
	@GetMapping("oil-type-manager.htm")
	public String init(ModelMap model) {
		//Cookie cookie=session.getCookie();
		//车类型
		model.put("oilTypeInfos",oilInfoMapper.queryALL());
		return "oil_type_manager";
	}
	@GetMapping("oil-type-manager/datas")
	@ResponseBody
	public DataTableDO<OilInfo> datas() {		
		DataTableDO<OilInfo> dataTableDO=new DataTableDO<OilInfo>();
		dataTableDO.setData(oilInfoMapper.queryALLJOIN());
		return dataTableDO;
	}	
	@PostMapping("oil-type-manager/edit")
	@ResponseBody
	public String update(String action,OilInfo obj) {		
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
