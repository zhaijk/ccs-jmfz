package com.derun.jczb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YouKuSunHao;
import com.derun.jczb.model.YoukuDictionary;
//import com.derun.jczb.service.CommitService;
import com.derun.jczb.service.YoukuSunhaoService;


/**
 *   油库损耗
 * @author Administrator
 *
 */
@Controller
public class YoukuShunhaoController {

	@Autowired 
	private YoukuSunhaoService youkuSunhaoService;
	
	@RequestMapping("youku_sunhao.htm")
	public String init(ModelMap model) {
		List<OilDictionary> oils=youkuSunhaoService.queryByOil("1");		
		List<YoukuDictionary> youkus=youkuSunhaoService.queryByYouku(2, 2);
		model.put("oils", oils);
		model.put("youkus", youkus);
		return "youku_sunhao";
	}
	@PostMapping("youku_sunhao/datas")
	@ResponseBody
	public QueryDataVO<YouKuSunHao> query(String gongyingyouku){
		QueryDataVO<YouKuSunHao> maps=new QueryDataVO<YouKuSunHao>();
		List<YouKuSunHao>  youkusunhaos=youkuSunhaoService.queryYoukuSunhao(gongyingyouku,"2013");
		maps.setData(youkusunhaos);
		return maps;
	}
	@PostMapping("youku_sunhao/edit")
	@ResponseBody
	public  String edit(YouKuSunHao shunhao,@RequestParam("oils[]") Double[] oils){
		return youkuSunhaoService.inputYksh(shunhao,oils);
	}
	
}
