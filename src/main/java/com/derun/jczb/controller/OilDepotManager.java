package com.derun.jczb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.derun.jczb.dao.OilDepotMapper;
//import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.dao.OilTypeMapper;
//import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YoukuDictionary;
/**
 *   油库油品管理
 * @author Administrator
 *
 */
@Controller
public class OilDepotManager {

	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(OilDepotManager.class);
	@Autowired
	private OilTypeMapper oilTypeMapper;	
	@Autowired
	private OilDepotMapper oilDepotMapper;
	
	
	@GetMapping("youku_youliao_manager.htm")
	public String init(ModelMap model) {
//		String departmentCode="7200";
//		//启用的油品类型
//   	List<OilDictionary> objs=oilInfoMapper.queryBy(departmentCode);
//   	model.put("oilTypeInfos", objs);
//   	//启用的油品类型
//   	List<YoukuDictionary> youkuInfos=oilDepotMapper.queryALL();
//   	model.put("youku_infos", youkuInfos);
		return "youku_youpin_manager";
	}	
	@GetMapping("oil_depot_manager/datas")
	@ResponseBody
	public DataTableDO<YoukuDictionary> datas() {	
		//String departmentCode="7200",jiezhuanDate="2015-12-26";
		List<YoukuDictionary> objs=oilDepotMapper.queryBy(1);
		DataTableDO<YoukuDictionary> dataTableDO=new DataTableDO<YoukuDictionary>();
		dataTableDO.setData(objs);
		return dataTableDO;
	}
	@PostMapping("oil_depot_manager/edit")
	@ResponseBody
	public String update(String action,YoukuDictionary obj) {
		int result=0;
		switch(action) {		
		case "add":
			obj.setFlag(1l);
			result=oilDepotMapper.updateOne(obj);
			break;
		case "del":
			obj.setFlag(0l);
			result=oilDepotMapper.updateOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
	@GetMapping("oil_depot_manager/getunuse")
	@ResponseBody
	public List<YoukuDictionary> queryUnuse() {		
   		List<YoukuDictionary>  objs=oilDepotMapper.queryBy(0);
		return objs;
	}
	@GetMapping("oil_type_manager/datas")
	@ResponseBody
	public DataTableDO<OilDictionary> recviver_datas() {	
		List<OilDictionary> objs=oilTypeMapper.queryBy(1);
		DataTableDO<OilDictionary> dataTableDO=new DataTableDO<OilDictionary>();
		dataTableDO.setData(objs);
		return dataTableDO;
	}
	@GetMapping("oil_type_manager/getunuse")
	@ResponseBody
	public List<OilDictionary> queryOilTypeUnuse() {		
   		List<OilDictionary>  objs=oilTypeMapper.queryBy(0);
		return objs;
	}
	@PostMapping("oil_type_manager/edit")
	@ResponseBody
	public String update_oil_type(String action,OilDictionary obj) {
		int result=0;
		switch(action) {		
		case "add":
			obj.setFlag(1l);
			result=oilTypeMapper.updateOne(obj);
			break;
		case "del":
			obj.setFlag(0l);
			result=oilTypeMapper.updateOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
