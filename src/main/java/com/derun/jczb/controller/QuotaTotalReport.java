package com.derun.jczb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.model.YouliaozhibiaoReport;

/**
 *      油料指标统计
 * @author Administrator
 *
 */
@Controller
public class QuotaTotalReport {
	
	@Autowired 
	private DepartmentIncomeMapper departmentIncome;
	
	@SuppressWarnings("unchecked")
	@GetMapping("quota_total_report.htm")
	public String init(ModelMap model) {
		
		List<YouliaozhibiaoReport> cur_youliaozhibiao=new ArrayList<YouliaozhibiaoReport>();
		List<YouliaozhibiaoReport> cur_oil=new ArrayList<YouliaozhibiaoReport>();
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("cur_youliaozhibiao",cur_youliaozhibiao);
		params.put("cur_oil",cur_oil);
		params.put("departmentcode","7200");
		params.put("niandu","2013");
		departmentIncome.youliao_zhibiao(params);
		cur_youliaozhibiao= (List<YouliaozhibiaoReport>) params.get("cur_youliaozhibiao");
		cur_oil=(List<YouliaozhibiaoReport>)params.get("cur_oil");		
		model.put("cur_youliaozhibiao", cur_youliaozhibiao);
		model.put("cur_oil", cur_oil);
		return "quota_total_report";
	}
	@SuppressWarnings("unchecked")
	private String getXmlString() {
		StringBuffer result = new StringBuffer();
		List<YouliaozhibiaoReport> cur_youliaozhibiao=new ArrayList<YouliaozhibiaoReport>();
		List<YouliaozhibiaoReport> cur_oil=new ArrayList<YouliaozhibiaoReport>();
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("cur_youliaozhibiao",cur_youliaozhibiao);
		params.put("cur_oil",cur_oil);
		params.put("departmentcode","7200");
		params.put("niandu","2013");
		departmentIncome.youliao_zhibiao(params);
		cur_youliaozhibiao= (List<YouliaozhibiaoReport>) params.get("cur_youliaozhibiao");
		cur_oil=(List<YouliaozhibiaoReport>)params.get("cur_oil");	
		
		result.append("<?xml version='1.0' encoding='gb2312'?>\n"+
				      "<EtCell AutoReportHeight='1'>\n"+
				      "<ETPrint>\n"+
				      "　<PrintFullPage value='TRUE' />\n"+
				      "　</ETPrint>\n"+
				      "<AliasData Name='AliasSet'>\n"+
				      "<name Value='2019 度油料指标汇总表' />\n");
		int counter=0;
		for (YouliaozhibiaoReport obj:cur_oil) {
			result.append("<A" + counter++ + " Value='" + obj.getName() + "' /> \n");
		}
		result.append("<B1 Value='" + "应供指标" + "' /> \n");
		result.append("<C1 Value='" + "上级调拨" + "' /> \n");
		result.append("<D1 Value='" + "本级支出" + "' /> \n");
		result.append("<E1 Value='" + "他部代供" + "' /> \n");
		result.append("<F1 Value='" + "代供他部" + "' /> \n");
		result.append("<G1 Value='" + "上级调拨" + "' /> \n");
		result.append("<H1 Value='" + "本级支出" + "' /> \n");
		
//		for(YouliaozhibiaoReport obj:cur_youliaozhibiao) {			
//			switch(obj.getId()) {
//			case 100:
//				result.append("<B2 Value='" + obj.getVolumn() + "' /> \n");
//				break;
//			case 200:
//				result.append("<C2 Value='" + obj.getVolumn() + "' /> \n");
//				break;
//			case 300:
//				result.append("<D2 Value='" + obj.getVolumn() + "' /> \n");
//				break;
//			case 400:
//				result.append("<E2 Value='" + obj.getVolumn() + "' /> \n");
//				break;	
//			case 500:
//				result.append("<F2 Value='" + obj.getVolumn() + "' /> \n");
//				break;
//			case 600:
//				result.append("<G2 Value='" + obj.getVolumn() + "' /> \n");
//				break;
//			case 700:
//				result.append("<H2 Value='" + obj.getVolumn() + "' /> \n");
//				break;			
//			}
//		}
		for(int i=2;i<13;i++) {
			result.append("<B"+i+" Value='12.0' /> \n");		
			result.append("<C"+i+" Value='0.34' /> \n");			
			result.append("<D"+i+" Value='56.0' /> \n");			
			result.append("<E"+i+" Value='0.78' /> \n");			
			result.append("<F"+i+" Value='90.12' /> \n");
			result.append("<G"+i+" Value='34.56' /> \n");			
			result.append("<H"+i+" Value='1234.56' /> \n");		
		}
		for(YouliaozhibiaoReport obj:cur_youliaozhibiao) {			
		switch(obj.getId()) {
		case 100:
			result.append("<B2 Value='" + obj.getVolumn() + "' /> \n");
			break;
		case 200:
			result.append("<C2 Value='" + obj.getVolumn() + "' /> \n");
			break;
		case 300:
			result.append("<D2 Value='" + obj.getVolumn() + "' /> \n");
			break;
		case 400:
			result.append("<E2 Value='" + obj.getVolumn() + "' /> \n");
			break;	
		case 500:
			result.append("<F2 Value='" + obj.getVolumn() + "' /> \n");
			break;
		case 600:
			result.append("<G2 Value='" + obj.getVolumn() + "' /> \n");
			break;
		case 700:
			result.append("<H2 Value='" + obj.getVolumn() + "' /> \n");
			break;			
		}
		}
		result.append("</AliasData>\n");
		result.append("</EtCell>");
		return result.toString();
	}
	@GetMapping("print_")
	public String print(ModelMap model) {
		model.put("xm_l", getXmlString());
		model.put("pa_th", "reportET/YouliaoZhibiaoTongjiRep.eT");
		return "atreport_youliao";
	}
}
