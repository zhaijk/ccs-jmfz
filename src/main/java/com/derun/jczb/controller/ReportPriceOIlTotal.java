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
import com.derun.jczb.model.SwYlLzZbTjReport;

/**
 *      实物油料指标统计
 * @author Administrator
 *
 */
@Controller
public class ReportPriceOIlTotal {
	
	@Autowired 
	private DepartmentIncomeMapper departmentIncome;
		
	@GetMapping("price_quota_total_report.htm")
	public String init(ModelMap  model) {
//		String  departmentCode="720001";
		List<String> years=new LinkedList<String>();
		setyears(years);
		model.addAttribute("years",years);	
		return "price_quota_total_report";
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
		result.append("<danwei Value='单位名称:" + departmentName + "'/>\n");
		result.append("<tablename Value='" + niandu + "年度价拨经费汇总表'/>\n");
		result.append("</AliasData>\n");
		result.append("<RowData Name='ETSet1'>\n");
		for (int i=1;i<13;i++) {
			result.append("<Row>\n");
			result.append("<Field1 Value='"+niandu+"-"+i+"'/>\n");
			result.append("<Field2 Value='" + 0.0 + "'/>\n");
			result.append("<Field3 Value='" + 0.0 + "'/>\n");
			result.append("<Field4 Value='" + 0.0 + "'/>\n");
			result.append("<Field5 Value='" + 0.0 + "'/>\n");
			result.append("</Row>\n");
		}
		result.append("</RowData>");
		result.append("</EtCell>");		
		return result.toString();
	}
	@PostMapping("price_quota_total_report/datas")
	@ResponseBody
	public DataTableDO<SwYlLzZbTjReport> queryLst(String niandu){
		
		HashMap<String ,Object> params=new HashMap<String,Object>();		
		if(niandu.equals("all"))
			params.put("niandu", 2013);
		else
			params.put("niandu", niandu);		
		params.put("departmentcode", "720004");	
		departmentIncome.jbjfhz(params);	
		@SuppressWarnings("unchecked")
		List<SwYlLzZbTjReport> cur_swylzbtj=(List<SwYlLzZbTjReport>) params.get("cur_niandujiabojingfei");
		DataTableDO<SwYlLzZbTjReport> dataTableDO=new DataTableDO<SwYlLzZbTjReport>();
		dataTableDO.setData(cur_swylzbtj);
		return dataTableDO;
	}
	@GetMapping("price_print_")
	public String print(ModelMap model, String niandu) {

		HashMap<String ,Object> params=new HashMap<String,Object>();		
		if(niandu.equals("all"))
			params.put("niandu", 2013);
		else
			params.put("niandu", niandu);
		params.put("departmentcode", "720004");
		departmentIncome.jbjfhz(params);
		@SuppressWarnings("unchecked")
		List<SwYlLzZbTjReport> cur_swylzbtj=(List<SwYlLzZbTjReport>) params.get("cur_niandujiabojingfei");
		model.put("xm_l", getXmlString(cur_swylzbtj,"首长办公室",niandu));
		model.put("pa_th", "reportET/NianduJingfeiRep.eT");
		return "atreport_youliao";
	}
}
