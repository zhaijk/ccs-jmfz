package com.derun.jczb.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.util.SessionInfo;
/**
 * info 自购实物油料
 * @author Administrator
 *
 */
@Controller
public class ZigouShiwuYouliao {
	
	//private Logger logger=LoggerFactory.getLogger(ZigouShiwuYouliao.class);
	@Autowired
	private OilInfoMapper oilInfoMapper;	
	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private DepartmentIncomeMapper departmentIncomeMapper;
	@Autowired
	private SessionInfo sessionInfo;	
	
	@GetMapping("zigoushiwuyouliao.htm")
	public String init(ModelMap model) {
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		String jiezhuanDate=sessionInfo.getJieZhuanDate();
   		//jiezhuanDate=sessionInfo.getJieZhuanDate();
		//启用的油品类型
   		List<OilDictionary> objs=oilInfoMapper.queryBy(departmentCode);
   		model.put("oilTypeInfos", objs);
   		List<DepartmentIncome> departmentIncomes=departmentIncomeMapper.queryZGYL(departmentCode,jiezhuanDate);
   		model.put("departmentIncomes", departmentIncomes);
		return "zigoushiwu";
	}	
	@GetMapping("zigoushiwuyouliao/datas")
	@ResponseBody
	public DataTableDO<DepartmentIncome> datas() {	
		String departmentCode=sessionInfo.getDepartmentCode();
   		String jiezhuanDate=sessionInfo.getJieZhuanDate();
		DataTableDO<DepartmentIncome> dataTableDO=new DataTableDO<DepartmentIncome>();
		dataTableDO.setData(departmentIncomeMapper.queryZGYL(departmentCode,jiezhuanDate));
		return dataTableDO;
	}
	@PostMapping("zigoushiwuyouliao/edit")
	@ResponseBody
	public String update(String action,DepartmentIncome obj) {
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		//String jiezhuanDate=sessionInfo.getJieZhuanDate();
		//logger.debug(action+"--"+obj.toString());
		int result=0;
		switch(action) {
		case "update":
			//油品代码
			obj.setOilType(oilDictionaryMapper.queryByName(obj.getOilName()));
			//油品密度
			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOilType())));
			//计算吨数
			obj.setTonNum(obj.getDensity()*obj.getInputGuideline2()/1000);
			result=departmentIncomeMapper.updateOne(obj);
			break;			
		case "insert":			
			//系统时间
			obj.setProvideDate2(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			//油品代码
			obj.setOilType(oilDictionaryMapper.queryByName(obj.getOilName()));
			//油品密度
			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOilType())));
			//计算吨数
			obj.setTonNum(obj.getDensity()*obj.getInputGuideline2()/1000);
			//部门编号
			obj.setDepartmentCode(departmentCode);
			//转换类型0
			obj.setCoverType(0);
			//incometype类型2
			obj.setIncomType(2);			
			result=departmentIncomeMapper.insertOne(obj);
			break;
		case "delete":
			result=departmentIncomeMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
