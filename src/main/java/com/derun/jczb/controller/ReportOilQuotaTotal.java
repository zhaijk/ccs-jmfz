package com.derun.jczb.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.SwYlLzZbTjReport;

/**
 *      实物油料指标统计
 * @author Administrator
 *
 */
@Controller
public class ReportOilQuotaTotal {
	
	@Autowired 
	private DepartmentIncomeMapper departmentIncome;
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	@Autowired
	private OilInfoMapper oilInfoMapper;
	
	@GetMapping("oil_quota_total_report.htm")
	public String init(ModelMap  model) {
		String  departmentCode="7200";
		List<DepartmentInfo> departmentNames=departmentInfoMapper.queryByDepartmentInfos(departmentCode);
		List<OilInfo> oilInfos=oilInfoMapper.queryByOilInfo(departmentCode);
		List<String> years=new LinkedList<String>();
		model.addAttribute("departmentInfos",departmentNames);
		model.addAttribute("oilInfos",oilInfos);
		setyears(years);
		model.addAttribute("years",years);	
		return "oil_quota_total_report";
	}
	private final int  YearCounter=10;
	private void setyears(List<String> years) {
		int yearNow=LocalDate.now().getYear();
		for(int i=0;i<YearCounter;i++) {
			years.add(String.valueOf(yearNow-i));
		}
	}
	private String getXmlString(List<SwYlLzZbTjReport> objs,String departmentName,String niandu) {
		StringBuffer result = new StringBuffer();	

		result.append("<?xml version='1.0' encoding='gb2312'?>\n"+
				      "<EtCell AutoReportHeight='1'>\n"+
				      "<ETPrint>\n"+
				      "　<PrintFullPage value='TRUE' />\n"+
				      "　</ETPrint>\n"+
				      "<AliasData Name='AliasSet'>\n"+
				      "<name Value='2019 度油料指标汇总表' />\n");
		//result.append("<oil Value='油品:" + oiltype + "'/>\n");
		result.append("<DW Value='单位名称:" + departmentName + "'/>\n");
		result.append("<tablename Value='"+niandu+"年度油料指标统计表'/>\n");
		result.append("</AliasData>\n");
		result.append("<RowData Name='ETSet1'>\n");
		for (SwYlLzZbTjReport obj:objs) {
			result.append("<Row>\n");
			result.append("<Field1 Value='" + obj.getRecorddate() + "'/>\n");
			result.append("<Field2 Value='" + obj.getSqjz() + "'/>\n");
			result.append("<Field3 Value='" + obj.getShouru() + "'/>\n");
			result.append("<Field4 Value='" + obj.getZhichu() + "'/>\n");
			result.append("<Field5 Value='" + obj.getJiechun() + "'/>\n");
			result.append("</Row>\n");
		}
		result.append("</RowData>");
		result.append("</EtCell>");		
		return result.toString();
	}
	@PostMapping("oil_quota_total_report/datas")
	@ResponseBody
	public DataTableDO<SwYlLzZbTjReport> queryLst(String departmentcode,String oil,String niandu){
		
		HashMap<String ,Object> params=new HashMap<String,Object>();
		if(departmentcode.equals("all")) {
			params.put("dbmcode","7200");
			params.put("departmentcode","7200");
		}else {
			params.put("dbmcode",departmentcode.substring(0,6));
			params.put("departmentcode",departmentcode.substring(0,6));
		}
		if(oil.equals("all"))
			params.put("oil",0);
		else
			params.put("oil",Integer.parseInt(oil));
		params.put("i",0);
		if(niandu.equals("all"))
			params.put("niandu", 2013);
		else
			params.put("niandu", niandu);
		params.put("guidelinetype", 0);		
		departmentIncome.swylzbtj(params);	
		@SuppressWarnings("unchecked")
		List<SwYlLzZbTjReport> cur_swylzbtj=(List<SwYlLzZbTjReport>) params.get("cur_swylzbtj");
		DataTableDO<SwYlLzZbTjReport> dataTableDO=new DataTableDO<SwYlLzZbTjReport>();
		dataTableDO.setData(cur_swylzbtj);
		return dataTableDO;
	}
	@GetMapping("oil_print_")
	public String print(ModelMap model,String departmentcode,String oil,String niandu) {
		//List<SwYlLzZbTjReport> cur_swylzbtj=queryLst();	
		HashMap<String ,Object> params=new HashMap<String,Object>();
		if(departmentcode.equals("all")) {
			params.put("dbmcode","7200");
			params.put("departmentcode","7200");
		}else {
			params.put("dbmcode",departmentcode.substring(0,6));
			params.put("departmentcode",departmentcode.substring(0,6));
		}
		if(niandu.equals("all"))
			params.put("niandu", 2013);
		else
			params.put("niandu", niandu);
		if(oil.equals("all"))
			params.put("oil",0);
		else
			params.put("oil",Integer.parseInt(oil));
		params.put("i",0);
		params.put("guidelinetype", 0);		
		departmentIncome.swylzbtj(params);
		@SuppressWarnings("unchecked")
		List<SwYlLzZbTjReport> cur_swylzbtj=(List<SwYlLzZbTjReport>) params.get("cur_swylzbtj");
		model.put("xm_l", getXmlString(cur_swylzbtj,departmentcode,niandu));
		model.put("pa_th", "reportET/NianduShiwuZhibiaoRep.eT");
		return "atreport_youliao";
	}
}
