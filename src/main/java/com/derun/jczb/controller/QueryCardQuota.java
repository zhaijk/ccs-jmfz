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

import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.DepartmentRecordMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.DepartmentRecord;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.QueryDataVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.media.jfxmedia.logging.Logger;


@Controller
public class QueryCardQuota {
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(GasStationManager.class);
	
	@Autowired
	private CardProvideMapper cardProvideMapper;
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	@Autowired
	private OilInfoMapper oilInfoMapper;
//	@Autowired
//	private DepartmentInfoMapper departmentInfoMapper;
//	
	@GetMapping("card_quota_query.htm")
	public String initial(ModelMap model) {
		String departmentCode="7200";
		//String jiezhuanDate="";
		//departmentRecordMapper.queryBy(departmentCode,jiezhuanDate);
		List<DepartmentInfo> departmentNames=departmentInfoMapper.queryByDepartmentInfos(departmentCode);
		List<OilInfo> oilInfos=oilInfoMapper.queryByOilInfo(departmentCode);
		model.put("departmentInfos",departmentNames);
		model.put("oilInfos",oilInfos);
		return "card_quota_query";
	}
	@PostMapping("card_quota_query/datas")
	@ResponseBody
	public QueryDataVO<CardProvideReport> query(String departs,String oiltypes,String sendtype,String cardcode,String writecard,String querydatestart,String querydatestop,String guidelinetype,HttpServletRequest request,int draw,int start ,int length){//,String[] columns,String[] order,String[] search){
		String departmentCode="7200";
		String jiezhuanDate="";

//		logger.info(draw+" "+start+" "+length+" ");//+columns+" "+order+" "+search);
//		logger.info(request.getParameter("order[0][column]"));
//		logger.info(request.getParameter("order[0][dir]"));
//		logger.info(request.getParameter("columns[0][data]"));
//		logger.info(request.getParameter("columns[1][data]"));
//		logger.info(request.getParameter("search[value]"));
//		logger.info(request.getParameter("search[regex]"));
//		logger.info(oiltypes+" "+querydatestart+" "+departs+" "+guidelinetype);
		if(departs.equals("all")==false) {
			departs=departs.substring(0,6);
		}
		if(null==oiltypes ||oiltypes.equals("")) {
			oiltypes="all";
		}
		if(null==guidelinetype ||guidelinetype.equals("")) {
			guidelinetype="all";
		}
		if(null==cardcode ||cardcode.equals("")) {
			cardcode="all";
		}
		if(null==querydatestart ||querydatestart.equals("")) {
			querydatestart="all";
		}
		if(null==querydatestop ||querydatestop.equals("")) {
			querydatestop="all";
		}
		Page<Object> pageObjs=PageHelper.startPage(start/10+1,length);
		List<CardProvideReport> objs=cardProvideMapper.queryBy(cardcode,jiezhuanDate,departs,oiltypes,guidelinetype,sendtype,writecard,querydatestart,querydatestop);
		//PageInfo<DepartmentRecord> pageInfo = new PageInfo<>(objs);
		QueryDataVO<CardProvideReport> maps=new QueryDataVO<CardProvideReport>();
//		int total=departmentRecordMapper.queryCount(departmentCode,jiezhuanDate);
		int total=(int) pageObjs.getTotal();
		maps.setDraw(draw+1);
		maps.setRecordsFiltered(total);
		maps.setRecordsTotal(total);
		maps.setData(objs);
		return maps;
	}
}
