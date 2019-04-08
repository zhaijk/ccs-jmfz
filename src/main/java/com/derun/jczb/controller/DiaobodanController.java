package com.derun.jczb.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartDictionaryMapper;
import com.derun.jczb.dao.DiaobodanMapper;
import com.derun.jczb.dao.DiaobodanRecordMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.YoukuDictionaryMapper;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.DiaobodanRecord;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
/**
 *    换单+油料调拨  
 * @author Administrator
 *
 */
@Controller
public class DiaobodanController {

	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private YoukuDictionaryMapper youkuDictionaryMapper;
//	@Autowired
//	private DepartDictionaryMapper departDictionaryMapper;
	@Autowired
	private DiaobodanMapper diaobodanMapper;
	@Autowired
	private DiaobodanRecordMapper diaobodanRecordMapper;
	
	@RequestMapping("youliao_huandan.htm")
	public String init(ModelMap model) {
		List<String> danjuhaos=diaobodanMapper.queryDanjuhao("2016");
		//List<DiaobodanRecord> oils=null;
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		List<YoukuDictionary> youkus=youkuDictionaryMapper.queryBy(1);
		//List<DeparDictionary> departs=departDictionaryMapper.queryBy();
		//List<Diaobodan> diaobodans=diaobodanMapper.queryByModel("all", "all", "all", "2016");		
		//model.put("diaobodans", diaobodans);
		
//		try {
//			System.out.println(danjuhao);
//		if(null==danjuhao || danjuhao.equals("") || danjuhao.equals("all")) {
//			oils=diaobodanRecordMapper.queryOils("2016"); 	
//		}else {
//			oils=diaobodanRecordMapper.queryOil("2016",danjuhao); 
//		}
//		}catch(Exception e) {
//			oils=diaobodanRecordMapper.queryOils("2016");
//		}
//		model.put("danjuhao", danjuhao);
		model.put("danjuhaos", danjuhaos);
		model.put("oils", oils);
		model.put("youkus", youkus);
		//model.put("departs", departs);
		return "youliao_huandan";
	}
	@PostMapping("youliao_huandan/datas")
	@ResponseBody
	public QueryDataVO<Diaobodan> query(int flagtype,String departs,String oiltypes,String danjuhao,String gongyingdanwei){
		QueryDataVO<Diaobodan> maps=new QueryDataVO<Diaobodan>();
		List<Diaobodan> diaobodans=diaobodanMapper.queryByModel(flagtype,gongyingdanwei,departs,danjuhao,"2016");		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					obj.getShiwu().add(record.getShiwu().toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
		}
		maps.setData(diaobodans);
		return maps;
	}
	@PostMapping("youliao_huandan/edit")
	@ResponseBody
	@Transactional(rollbackFor=SQLException.class)
	public  String edit(Diaobodan diaobodan,List<String> values){		
		diaobodanMapper.insertOne(diaobodan);
		for(String obj:values) {
			DiaobodanRecord record=new DiaobodanRecord();
			record.setFk_id(diaobodan.getId());
			record.setYoupin_code(Long.parseLong(obj));
			record.setShiwu(Double.parseDouble(obj));
			diaobodanRecordMapper.insertOne(record);
		}
		return "success";
	}
	@PostMapping("youliao_huandan/getshangjidiaobodan")
	@ResponseBody
	public Diaobodan querySJ(String departs,String oiltypes,String danjuhao,String gongyingdanwei){
		List<Diaobodan> diaobodans=diaobodanMapper.queryByModel(1,gongyingdanwei,departs,danjuhao,"2016");		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					obj.getShiwu().add(record.getShiwu().toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
		}
		return diaobodans.get(0);
	}
}
