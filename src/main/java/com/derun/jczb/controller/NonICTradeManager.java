package com.derun.jczb.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
//import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.util.SessionInfo;

@Controller
public class NonICTradeManager {

	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(NonICTradeManager.class);
	
	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
//	@Autowired 
//	private OilInfoMapper oilInfoMapper;
	@Autowired
	private SessionInfo session;
	@GetMapping("card-trade-nonIC-manager.htm")
	public String init(ModelMap model) {
//		//Cookie cookie=session.getCookie();
//		//车类型
//		model.put("carTypeInfos",carTypeMapper.queryALL());	
		//部门
		model.put("departInfos",departmentInfoMapper.queryALL());	
//		model.put("carInfos",carInfoMapper.queryALLUnions());		
		return "card_trade_nonIC_manager";
	}
	@GetMapping("card-trade-nonIC-manager/datas")
	@ResponseBody
	public DataTableDO<CardTrade> datas() {		
		DataTableDO<CardTrade> dataTableDO=new DataTableDO<CardTrade>();
		dataTableDO.setData(cardTradeMapper.queryNonIcTradeBy("1", session.getJieZhuanDate(), session.getDepartmentCode()));
		return dataTableDO;
	}	
}
