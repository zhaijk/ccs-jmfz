package com.derun.jczb.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.SwYlLzZbTjReport;
import com.derun.jczb.model.SwYlXhTjReport;

/**
 *      实物油料消耗统计表
 * @author Administrator
 *
 */
@Controller
public class ReportOilTradeStatistics {
	
	@Autowired 
	private DepartmentIncomeMapper departmentIncome;
	@Autowired 
	private DepartmentInfoMapper departmentInfo;
	
	@GetMapping("oil_trade_total_report.htm")
	public String init(ModelMap  model) {
		
		List<DepartmentInfo> departmentInfos =departmentInfo.queryALL();
		model.put("departs",departmentInfos);
		return "oil_trade_total_report";
	}	
	private String getXmlString(List<SwYlLzZbTjReport> objs,String departmentName,String niandu) {
		
		StringBuffer result = new StringBuffer();
		result.append("<?xml version='1.0' encoding='gb2312'?>\n"+
				      "<EtCell AutoReportHeight='1'>\n"+
				      "<ETPrint>\n"+
				      "　<PrintFullPage value='TRUE' />\n"+
				      "　</ETPrint>\n"+
				      "<AliasData Name='AliasSet'>\n");		
		result.append("<top Value='" + niandu + "年度实物油料消耗统计表' /> \n");
		result.append("<danwei Value='部门名称:" + "首长" + "' /> \n");
		result.append("<A0 Value='小计' /> \n");
		for (int i = 0; i < 6; i++) {
			result.append("<A" + i + " Value='" + "各种油品" + "' /> \n");
		}
		//设置合计 升
		for (int i = 0; i < 12; i++) {
			result.append("<V" + i + " Value='" + 0.0 + "' /> \n");
		}
		//设置合计 吨
		for (int i = 0; i < 12; i++) {
			result.append("<T" + i + " Value='" + 0.0 + "' /> \n");
		}
		
		result.append("</AliasData>\n");
		result.append("<RowData Name='ETSet1' >");		
		result.append("<Row>\n");
		result.append("<Field1 Value='" + 0.0 + "' /> \n");
		result.append("<Field" + 1 + " Value='' /> \n");
		result.append("</Row>\n");		
		result.append("</RowData>");
		result.append("</EtCell>");	
		return result.toString();
	}
	@PostMapping("oil_trade_total_report/datas")
	@ResponseBody
	public DataTableDO<SwYlXhTjReport> queryLst(String departmentcode){
		
		HashMap<String ,Object> params=new HashMap<String,Object>();		
		if(departmentcode.equals("all"))
			params.put("departmentcode", "7200");
		else
			params.put("departmentcode", departmentcode.substring(0,6));
		params.put("niandu", 2013);
		departmentIncome.swylxhtj(params);	
		@SuppressWarnings("unchecked")
		List<SwYlXhTjReport> cur_niandushiwuxiaohao=(List<SwYlXhTjReport>) params.get("cur_niandushiwuxiaohao");
		@SuppressWarnings("unchecked")
		List<SwYlXhTjReport> cur_oil=(List<SwYlXhTjReport>) params.get("cur_oil");
		for(SwYlXhTjReport objoil:cur_oil) {
			int flag=0;
			for(SwYlXhTjReport objxiaohao:cur_niandushiwuxiaohao) {
				if(objoil.getOiltype()==Integer.parseInt(objxiaohao.getToi())) {
					flag=1;break;
				}				
			}
			if(flag==0) {
				cur_oil.remove(objoil);				
			}
			flag=0;
		}
		DataTableDO<SwYlXhTjReport> dataTableDO=new DataTableDO<SwYlXhTjReport>();
		dataTableDO.setData(cur_niandushiwuxiaohao);
		dataTableDO.setData(cur_oil);
		return dataTableDO;
	}
	@GetMapping("oil_trade_total_print")
	public String print(ModelMap model, String departmentcode) {

		HashMap<String ,Object> params=new HashMap<String,Object>();		
		if(departmentcode.equals("all"))
			params.put("departmentcode", "7200");
		else
			params.put("departmentcode", departmentcode);
		params.put("niandu", 2013);
		departmentIncome.jbjfhz(params);
		@SuppressWarnings("unchecked")
		List<SwYlLzZbTjReport> cur_swylzbtj=(List<SwYlLzZbTjReport>) params.get("cur_niandujiabojingfei");
		model.put("xm_l", getXmlString(cur_swylzbtj,"首长办公室","2013"));
		model.put("pa_th", "reportET/NianduShiwuXiaohaoRep.eT");
		return "atreport_youliao";
	}
}
