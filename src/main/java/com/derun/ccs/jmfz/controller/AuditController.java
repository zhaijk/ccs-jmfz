package com.derun.ccs.jmfz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.ccs.jmfz.dao.AuditMapper;
import com.derun.ccs.jmfz.dao.CcsHdXxMapper;
import com.derun.ccs.jmfz.model.BXGS;
import com.derun.ccs.jmfz.model.TotalInfo;
/**
 * info审核
 * @author Administrator
 *
 */
@Controller
public class AuditController {

	@Autowired
	private  CcsHdXxMapper ccsHdXxMapper;
	@Autowired
	private AuditMapper auditMapper;
	
	@GetMapping("audit.htm")
	public String init() {
		return "audit";
	}
	@GetMapping("auditquery/xny")
	@ResponseBody
	public DataTableDO<TotalInfo> queryXNY() {
		DataTableDO<TotalInfo> dataTableDO=new DataTableDO<TotalInfo>();
		dataTableDO.setData(ccsHdXxMapper.queryXNYTotal());
		return dataTableDO;
	}	
	@GetMapping("auditquery/sh")
	@ResponseBody
	public DataTableDO<TotalInfo> querySH() {
		ccsHdXxMapper.deleteRepeat();
		DataTableDO<TotalInfo> dataTableDO=new DataTableDO<TotalInfo>();
		dataTableDO.setData(ccsHdXxMapper.querySHTotal());
		return dataTableDO;
	}	
	@GetMapping("auditquery/total")
	@ResponseBody
	public DataTableDO<TotalInfo> queryTotal() {
		DataTableDO<TotalInfo> dataTableDO=new DataTableDO<TotalInfo>();
		dataTableDO.setData(ccsHdXxMapper.queryTotal());
		return dataTableDO;
	}
	@GetMapping("audit/operation")
	@ResponseBody
	public String execAudit() {		
		ccsHdXxMapper.deleteAll();
		auditMapper.audit();
		return "success";
	}
}
