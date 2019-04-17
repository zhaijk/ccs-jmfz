package com.derun.jczb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.service.CommitService;

/**
 *       自购实物油料   
 * @author Administrator
 *
 */
@Controller
public class ZgSwController {

	@Autowired 
	private CommitService commitService;
	
	@RequestMapping("youliao_zigou.htm")
	public String init(ModelMap model) {
		List<OilDictionary> oils=commitService.queryByOil("1");		
		List<YoukuDictionary> youkus=commitService.queryByYouku(2, 2);
		model.put("oils", oils);
		model.put("youkus", youkus);
		return "youliao_zigou";
	}
	@PostMapping("youliao_zigou/datas")
	@ResponseBody
	public QueryDataVO<Diaobodan> query(String gongyingyouku){
		QueryDataVO<Diaobodan> maps=new QueryDataVO<Diaobodan>();
		List<Diaobodan> diaobodans=commitService.queryZigou(gongyingyouku,"2015");
		maps.setData(diaobodans);
		return maps;
	}
	@PostMapping("youliao_zigou/edit")
	@ResponseBody
	public  String edit(Diaobodan diaobodan,@RequestParam("oils[]") Integer[] oils){
		//'kaidanriqi':dateselect,'gongyingyouku':gongyingyouku,'memo':memo,'oils':oilvals
		String result=commitService.insertZiGou(diaobodan, oils);// .insertHuandan(diaobodan, oils);
		return result;
	}	
}
