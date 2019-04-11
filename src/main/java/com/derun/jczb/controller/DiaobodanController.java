package com.derun.jczb.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.derun.jczb.dao.DepartDictionaryMapper;
import com.derun.jczb.dao.DiaobodanMapper;
import com.derun.jczb.dao.DiaobodanRecordMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.YoukuDictionaryMapper;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.DiaobodanRecord;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.service.CommitService;
import com.derun.util.DataTypeConverter;
//import com.derun.jczb.service.CommitService;
/**
 *    解放军换单   
 * @author Administrator
 *
 */
@Controller
public class DiaobodanController {

//	@Autowired
//	private OilDictionaryMapper oilDictionaryMapper;
//	@Autowired
//	private YoukuDictionaryMapper youkuDictionaryMapper;
////	@Autowired
////	private DepartDictionaryMapper departDictionaryMapper;
//	@Autowired
//	private DiaobodanMapper diaobodanMapper;
//	@Autowired
//	private DiaobodanRecordMapper diaobodanRecordMapper;
	@Autowired 
	private CommitService commitService;
	
	@RequestMapping("youliao_huandan.htm")
	public String init(ModelMap model) {
		//List<String> danjuhaos=diaobodanMapper.queryDanjuhao("2016");
		List<String> danjuhaos=commitService.queryDanjuhao("2016");
		//List<DiaobodanRecord> oils=null;
		//List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		List<OilDictionary> oils=commitService.queryByOil("1");
		
		List<YoukuDictionary> youkus=commitService.queryByYouku(1, 2);
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
		List<Diaobodan> diaobodans=commitService.queryDiaobodanIncomePayment(gongyingdanwei, departs, danjuhao, "2016");
		maps.setData(diaobodans);
		return maps;
	}
	@PostMapping("youliao_huandan/edit")
	@ResponseBody
	public  String edit(Diaobodan diaobodan,@RequestParam("oils[]") Integer[] oils){
		
		String result=commitService.insertDiaobodan(diaobodan, oils);
		return result;
	}
	/*@PostMapping("youliao_huandan/getshangjidiaobodan")
	@ResponseBody
	public Diaobodan querySJ(String departs,String oiltypes,String danjuhao,String gongyingdanwei){
		List<Diaobodan> diaobodans=diaobodanMapper.queryByModel(1,gongyingdanwei,departs,danjuhao,"2016");		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			double total=0;
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					total+=record.getShiwu();
					obj.getShiwu().add(record.getShiwu().toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
			if(obj.getLeixing()==1) {//上级调拨单
				obj.setIncome(total);
			}else if(obj.getLeixing()==3) {
				obj.setPayment(total);
			}
		}
		//计算汇总
		double income=0;
		double payment=0;
		double balance=0;
		for(Diaobodan obj:diaobodans){
			if(obj.getLeixing()==1) {
				income+=obj.getIncome();
			}else if(obj.getLeixing()==3) {
				payment+=obj.getPayment();
			}
		}
		balance=income-payment;
		Diaobodan total=new Diaobodan();
		total.setIncome(income);
		total.setPayment(payment);
		total.setBalance(balance);
		
		return diaobodans.get(0);
	}*/
}
