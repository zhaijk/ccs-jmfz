package com.derun.jczb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.DepartmentRecordMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.DepartmentRecord;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.QueryDataVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.media.jfxmedia.logging.Logger;
/**
 *   查询部门指标
 * @author Administrator
 *
 */

@Controller
public class QueryDepartmentQuota {
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(GasStationManager.class);
	
	@Autowired
	private DepartmentRecordMapper departmentRecordMapper;
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	@Autowired
	private OilInfoMapper oilInfoMapper;
//	@Autowired
//	private DepartmentInfoMapper departmentInfoMapper;
//	
	@GetMapping("depart_record_query.htm")
	public String initial(ModelMap model) {
		String departmentCode="7200";
		//String jiezhuanDate="";
		//departmentRecordMapper.queryBy(departmentCode,jiezhuanDate);
		List<String> departmentNames=departmentInfoMapper.queryByDepartmentNames(departmentCode);
		List<OilInfo> oilInfos=oilInfoMapper.queryByOilInfo(departmentCode);
		model.put("departmentNames",departmentNames);
		model.put("oilInfos",oilInfos);
		return "depart_record_query";
	}
	@PostMapping("depart_record_query/datas")
	@ResponseBody
	public QueryDataVO<DepartmentRecord> query(String guidelinetype,String oiltypes,String querydate,String departs,HttpServletRequest request,int draw,int start ,int length){//,String[] columns,String[] order,String[] search){
		String departmentCode="7200";
		String jiezhuanDate="";

//		logger.info(draw+" "+start+" "+length+" ");//+columns+" "+order+" "+search);
//		logger.info(request.getParameter("order[0][column]"));
//		logger.info(request.getParameter("order[0][dir]"));
//		logger.info(request.getParameter("columns[0][data]"));
//		logger.info(request.getParameter("columns[1][data]"));
//		logger.info(request.getParameter("search[value]"));
//		logger.info(request.getParameter("search[regex]"));
//		logger.info(oiltypes+" "+querydate+" "+departs+" "+guidelinetype);
		if(null==querydate ||querydate.equals("")) {
			querydate="all";
		}

		Page<Object> pageObjs=PageHelper.startPage(start/10+1,length);
		List<DepartmentRecord> objs=departmentRecordMapper.queryBy(departmentCode,jiezhuanDate,departs,oiltypes,guidelinetype,querydate);
		//PageInfo<DepartmentRecord> pageInfo = new PageInfo<>(objs);
		QueryDataVO<DepartmentRecord> maps=new QueryDataVO<DepartmentRecord>();
//		int total=departmentRecordMapper.queryCount(departmentCode,jiezhuanDate);
		int total=(int) pageObjs.getTotal();
		maps.setDraw(draw+1);
		maps.setRecordsFiltered(total);
		maps.setRecordsTotal(total);
		maps.setData(objs);
		return maps;
	}
}
