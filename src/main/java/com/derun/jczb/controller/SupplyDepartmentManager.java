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

import com.derun.jczb.dao.DepartDictionaryMapper;
//import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.JunquDictionaryMapper;
//import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.DeparDictionary;
//import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.JunquDictionary;
//import com.derun.jczb.model.OilDictionary;


/**
 *     供应单位 受供单位管理
 * @author Administrator
 * 
 */
@Controller
public class SupplyDepartmentManager {
	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(SupplyDepartmentManager.class);
	@Autowired 
	private  JunquDictionaryMapper junquDictionaryMapper;
	@Autowired 
	private  DepartDictionaryMapper departDictionaryMapper;
	
	@GetMapping("supply_department_manager.htm")
	public String init(ModelMap model) {
		//String departmentCode="720000000000",jiezhuanDate="2015-12-26";
   		//jiezhuanDate=departmentIncomeMapper.jiezhuandate();
		//启用的油品类型
   		//List<OilDictionary> objs=oilInfoMapper.queryBy(departmentCode);
   		//model.put("oilTypeInfos", objs);
   		//List<DepartmentIncome> departmentIncomes=departmentIncomeMapper.queryZGYL(departmentCode,jiezhuanDate);
   		//model.put("departmentIncomes", departmentIncomes);
		return "supply_department_manager";
	}	
	@GetMapping("supply_department_manager/datas")
	@ResponseBody
	public DataTableDO<JunquDictionary> datas() {	
		//String departmentCode="7200",jiezhuanDate="2015-12-26";
   		List<JunquDictionary>  objs=junquDictionaryMapper.queryALL();
		DataTableDO<JunquDictionary> dataTableDO=new DataTableDO<JunquDictionary>();
		dataTableDO.setData(objs);
		return dataTableDO;
	}
	@PostMapping("supply_department_manager/edit")
	@ResponseBody
	public String update(String action,JunquDictionary obj) {
		int result=0;
		switch(action) {		
		case "add":
			obj.setBiaozhi(1l);
			result=junquDictionaryMapper.updateOne(obj);
			break;
		case "del":
			obj.setBiaozhi(0l);
			result=junquDictionaryMapper.updateOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
	@GetMapping("supply_department_manager/getunuse")
	@ResponseBody
	public List<JunquDictionary> queryUnuse() {		
   		List<JunquDictionary>  objs=junquDictionaryMapper.queryBy();
		return objs;
	}
	@GetMapping("recviver_department_manager/datas")
	@ResponseBody
	public DataTableDO<DeparDictionary> recviver_datas() {	
		//String departmentCode="7200",jiezhuanDate="2015-12-26";
   		List<DeparDictionary>  objs=departDictionaryMapper.queryALL();
		DataTableDO<DeparDictionary> dataTableDO=new DataTableDO<DeparDictionary>();
		dataTableDO.setData(objs);
		return dataTableDO;
	}
	@PostMapping("recviver_department_manager/edit")
	@ResponseBody
	public String recv_depart_manager(String action,DeparDictionary obj) {
		int result=0;
		switch(action) {		
		case "add":
			result=departDictionaryMapper.insertOne(obj);
			break;
		case "del":
			result=departDictionaryMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
