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

import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.dao.OillossMapper;
import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.Oilloss;
import com.derun.jczb.util.SessionInfo;
/**
 * info  加油站损耗信息管理
 * @author Administrator
 *
 */
@Controller
public class OilLossManager {
/*	@SuppressWarnings("unused")
	private Logger logger=LoggerFactory.getLogger(OilLossManager.class);
*/	
	@Autowired
	private OillossMapper oillossMapper;
	@Autowired
	private OilInfoMapper oilInfoMapper;
	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private SessionInfo sessionInfo;
	
	@GetMapping("gasstation-loss-manager.htm")
	public String init(ModelMap model) {
//		//Cookie cookie=session.getCookie();
//		//车类型
//		model.put("carTypeInfos",carTypeMapper.queryALL());	
		//部门
		//model.put("departInfos",departmentInfoMapper.queryALL());	
//		model.put("carInfos",carInfoMapper.queryALLUnions());		
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		//启用的油品类型
   		List<OilDictionary> objs=oilInfoMapper.queryBy(departmentCode);
		model.put("oilTypeInfos", objs);
		return "gasstation_loss";
	}
	@GetMapping("gasstation-loss-manager/datas")
	@ResponseBody
	public DataTableDO<Oilloss> datas() {		
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		String jiezhuanDate=sessionInfo.getJieZhuanDate();
		DataTableDO<Oilloss> dataTableDO=new DataTableDO<Oilloss>();
		dataTableDO.setData(oillossMapper.queryBy(departmentCode, jiezhuanDate));
		return dataTableDO;
	}
	@PostMapping("gasstation-loss-manager/edit")
	@ResponseBody
	public String update(String action,Oilloss obj) {
		String departmentCode=sessionInfo.getUserInfo().getDanwei();
		int result=0;
		switch(action) {
		case "update":
/*			//油品代码
			obj.setOilType(oilDictionaryMapper.queryByName(obj.getOilName()));
			//油品密度
			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOilType())));
			//计算吨数
			obj.setTonNum(obj.getDensity()*obj.getInputGuideline2()/1000);*/
			//System.out.println(obj.toString());
			obj.setOiltype(oilDictionaryMapper.queryByName(obj.getOilName()));
			System.out.println(obj.toString());
			result=oillossMapper.updateOne(obj);
			break;			
		case "insert":			
/*			//系统时间
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
			obj.setIncomType(2);	*/	
			//obj.setDensity();
			obj.setDanweiid(departmentCode);
			obj.setLossdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			//油品代码
			obj.setOiltype(oilDictionaryMapper.queryByName(obj.getOilName()));
			//油品密度
			obj.setDensity(oilInfoMapper.queryDensityBy(departmentCode, String.valueOf(obj.getOiltype())));
			result=oillossMapper.insertOne(obj);
			break;
		case "delete":
			result=oillossMapper.deleteOne(obj);
			break;			
		}
		return result==1 ? "success" : "failure";
	}
}
