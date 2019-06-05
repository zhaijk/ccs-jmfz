package com.derun.ccs.jmfz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.ccs.jmfz.dao.BXGSMapper;
import com.derun.ccs.jmfz.dao.CcsHdXxMapper;
import com.derun.ccs.jmfz.model.CcsHdXx;
import com.derun.ccs.jmfz.model.QueryDataVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
/*import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
*/
@Controller
public class QueryController {

	@Autowired
	private CcsHdXxMapper ccsHdXxMapper;
	@Autowired
	private BXGSMapper bXGSmapper;
	
	
	@GetMapping("dataquery.htm")
	public String init(ModelMap model,String type) {
		model.put("bxgsinfos", bXGSmapper.queryALLBXGS());
		model.put("type_init", type);
		return "dataquery";
	}
	@PostMapping("dataquery/datas")
	@ResponseBody
	public QueryDataVO<CcsHdXx> query(String nsrmc,String type,String bxgs,String hmhp,String querydatestart,String querydatestop,HttpServletRequest request,int draw,int start ,int length) {
		if(null==nsrmc ||nsrmc.equals("")) {
			nsrmc="all";
		}else
			nsrmc=nsrmc.trim();
		if(null==hmhp ||hmhp.equals("")) {
	 		hmhp="all";
		}else
			hmhp=hmhp.trim();
		if(null==querydatestart ||querydatestart.equals("")) {
			querydatestart="all";
		}
		if(null==querydatestop ||querydatestop.equals("")) {
			querydatestop="all";
		}
		Page<Object> pageObjs=PageHelper.startPage(start/10+1,length);
		System.out.println(type+" "+bxgs+" "+hmhp+" "+querydatestart+" "+querydatestop);
		List<CcsHdXx> objs=ccsHdXxMapper.queryBy(nsrmc,type, bxgs, hmhp, querydatestart, querydatestop);
		//PageInfo<CcsHdXx> pageInfo = new PageInfo<>(objs);
		QueryDataVO<CcsHdXx> maps=new QueryDataVO<CcsHdXx>();
		maps.setDraw(draw+1);
		int total=(int) pageObjs.getTotal();
		maps.setRecordsFiltered(total);
		maps.setRecordsTotal(total);
		for(CcsHdXx obj:objs) {
			obj.setCSDJRQ(obj.getCSDJRQ().substring(0,10));
			obj.setHDSJ(obj.getHDSJ().substring(0, obj.getHDSJ().length()-2));
			obj.setSTRJMBL(obj.getJMBL()==0?"0":(int)(obj.getJMBL()*100)+"%");
		}
		maps.setData(objs);
		return maps;
	}	
}
