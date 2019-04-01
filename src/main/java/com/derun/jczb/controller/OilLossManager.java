package com.derun.jczb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.OillossMapper;
import com.derun.jczb.model.Oilloss;

@Controller
public class OilLossManager {
	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(OilLossManager.class);
	
	@Autowired
	private OillossMapper oillossMapper;
	
	@GetMapping("gasstation-loss-manager.htm")
	public String init(ModelMap model) {
//		//Cookie cookie=session.getCookie();
//		//车类型
//		model.put("carTypeInfos",carTypeMapper.queryALL());	
		//部门
		//model.put("departInfos",departmentInfoMapper.queryALL());	
//		model.put("carInfos",carInfoMapper.queryALLUnions());		
		return "gasstation_loss";
	}
	@GetMapping("gasstation-loss-manager/datas")
	@ResponseBody
	public DataTableDO<Oilloss> datas() {		
		DataTableDO<Oilloss> dataTableDO=new DataTableDO<Oilloss>();
		dataTableDO.setData(oillossMapper.queryALL());
		return dataTableDO;
	}	
}
