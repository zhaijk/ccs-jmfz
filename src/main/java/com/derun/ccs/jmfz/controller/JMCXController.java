package com.derun.ccs.jmfz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.ccs.jmfz.dao.JMDMMapper;
import com.derun.ccs.jmfz.model.JMDM;


/**
 * info 减免车型信息管理
 * @author Administrator
 *
 */
@Controller
public class JMCXController {

	@Autowired
	private JMDMMapper jMDMMapper;
	
	@GetMapping("jianmianchexing.htm")
	public String init() {
		return "jianmianchexing";
	}
	@GetMapping("jianmianchexing/datas")
	@ResponseBody
	public DataTableDO<JMDM> query() {
		DataTableDO<JMDM> dataTableDO=new DataTableDO<JMDM>();
		dataTableDO.setData(jMDMMapper.queryALLJMLX());
		return dataTableDO;
	}
}
