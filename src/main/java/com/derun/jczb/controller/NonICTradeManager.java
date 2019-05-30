package com.derun.jczb.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.OilInfoMapper;

import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.util.SessionInfo;
/**
 * info 非IC卡消耗录入
 * @author Administrator
 *
 */
@Controller
public class NonICTradeManager {

	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(NonICTradeManager.class);
	
	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired 
	private OilInfoMapper oilInfoMapper;
	@Autowired
	private SessionInfo sessionInfo;
	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	
	@GetMapping("card-trade-nonIC-manager.htm")
	public String init(ModelMap model) {
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		//启用的油品类型
   		List<OilDictionary> oilTypeInfos=oilInfoMapper.queryBy(departmentCode);
   		//启用的油品类型
   		List<DepartmentInfo> departmentInfos=departmentInfoMapper.queryByDepartmentInfos(departmentCode.substring(0, 4));
   		model.put("oilTypeInfos", oilTypeInfos);
   		model.put("departmentInfos", departmentInfos);
		return "card_trade_nonIC_manager";
	}
	@GetMapping("card-trade-nonIC-manager/datas")
	@ResponseBody
	public DataTableDO<CardTrade> datas() {		
		String jiezhuanDate=sessionInfo.getJieZhuanDate();
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		DataTableDO<CardTrade> dataTableDO=new DataTableDO<CardTrade>();
		dataTableDO.setData(cardTradeMapper.queryNonIcTradeBy("1", jiezhuanDate,departmentCode));
		return dataTableDO;
	}
	@PostMapping("card-trade-nonIC-manager/edit")
	@ResponseBody
	public String update(String action,CardTrade obj) {
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		//String jiezhuanDate=sessionInfo.getJieZhuanDate();
		//logger.debug(action+"--"+obj.toString());
		int result=0;
		switch(action) {
		case "update":
//			//油品代码
//			obj.setOilType(oilDictionaryMapper.queryByName(obj.getOilName()));
//			//油品密度
//			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOilType())));
//			//计算吨数
//			obj.setTonNum(obj.getDensity()*obj.getInputGuideline2()/1000);
			
			result=cardTradeMapper.updateOne(obj);
			break;			
		case "insert":		
			//操作日期
			obj.setTradedate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			//操作时间
			obj.setTradetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			//obj.setCardcode();
			//系统时间
//			obj.setProvideDate2(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//			//油品代码
//			obj.setOilType(oilDictionaryMapper.queryByName(obj.getOilName()));
//			//油品密度
//			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOilType())));
//			//计算吨数
//			obj.setTonNum(obj.getDensity()*obj.getInputGuideline2()/1000);
//			//部门编号
//			obj.setDepartmentCode(departmentCode);
//			//转换类型0
//			obj.setCoverType(0);
//			//incometype类型2
//			obj.setIncomType(2);			
			result=cardTradeMapper.insertOne(obj);
			break;
		case "delete":
			result=cardTradeMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
