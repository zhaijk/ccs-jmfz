package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.service.CommitService;
/**
 *     油料调拨 解放军 武警  
 * @author Administrator
 *
 */
@Controller
public class DiaoboController {

	@Autowired
	private CommitService commitService;
	
	@RequestMapping("youliao_diaobo.htm")
	public String init(ModelMap model) {
		List<YoukuDictionary> jfjyoukus=commitService.queryByYouku(1, 2);
		List<YoukuDictionary> wjyoukus=commitService.queryByYouku(2, 2);
		List<DeparDictionary> departs=commitService.queryDepartInfo();
		List<OilDictionary> oils=commitService.queryByOil("1");
		model.put("jfjyoukus", jfjyoukus);
		model.put("wjyoukus", wjyoukus);
		model.put("departs", departs);
		model.put("oils", oils);
		return "youliao_diaobo";
	}
	@PostMapping("youliao_diaobo/datas")
	@ResponseBody
	public QueryDataVO<Diaobodan> query(String jyjyoukus,String shougongdanwei){
		QueryDataVO<Diaobodan> maps=new QueryDataVO<Diaobodan>();
		List<Diaobodan> objs=commitService.queryDiaoboIncomePayment(jyjyoukus,shougongdanwei, "2016");
		maps.setData(objs);
		return maps;
	}
	@PostMapping("youliao_diaobo/edit")
	@ResponseBody	
	public  String edit(Diaobodan diaobodan,@RequestParam("oils[]") Integer[] oils){		
		commitService.insertDiaobo(diaobodan,oils);
		return "success";
	}
}
