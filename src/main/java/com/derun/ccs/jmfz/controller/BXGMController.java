package com.derun.ccs.jmfz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.ccs.jmfz.dao.BXGSMapper;
import com.derun.ccs.jmfz.model.BXGS;

/**
 * info 保险公司信息管理
 * @author Administrator
 *
 */
@Controller
public class BXGMController {

	@Autowired
	private BXGSMapper bXGSmapper;
	
	@GetMapping("baoxiangongsi.htm")
	public String init() {
		return "baoxiangongsi";
	}
	@GetMapping("baoxiangongsi/datas")
	@ResponseBody
	public DataTableDO<BXGS> query() {
		DataTableDO<BXGS> dataTableDO=new DataTableDO<BXGS>();
		dataTableDO.setData(bXGSmapper.queryALLBXGS());
		return dataTableDO;
	}
}
