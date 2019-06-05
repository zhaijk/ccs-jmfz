package com.derun.ccs.jmfz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.ccs.jmfz.dao.JMLXMapper;
import com.derun.ccs.jmfz.model.JMLX;

/**
 * info 减免类型信息管理
 * @author Administrator
 *
 */
@Controller
public class JMLXController {

	@Autowired
	private JMLXMapper jMLXMapper;
	
	@GetMapping("jianmianleixing.htm")
	public String init() {
		return "jianmianleixing";
	}
	@GetMapping("jianmianleixing/datas")
	@ResponseBody
	public DataTableDO<JMLX> query() {
		DataTableDO<JMLX> dataTableDO=new DataTableDO<JMLX>();
		dataTableDO.setData(jMLXMapper.queryALLJMLX());
		return dataTableDO;
	}
}
