package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.DepartDictionaryMapper;
import com.derun.jczb.dao.DiaobodanMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.YoukuDictionaryMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
/**
 *    换单+油料调拨 添加换单业务和调拨业务
 * @author Administrator
 *
 */
@Controller
public class DiaobodanController {

	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private YoukuDictionaryMapper youkuDictionaryMapper;
	@Autowired
	private DepartDictionaryMapper departDictionaryMapper;
	@Autowired
	private DiaobodanMapper diaobodanMapper;
	
	@RequestMapping("youliao_diaobo.htm")
	public String init(ModelMap model) {
		List<String> danjuhaos=diaobodanMapper.queryDanjuhao("2016");
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		List<YoukuDictionary> youkus=youkuDictionaryMapper.queryBy();
		List<DeparDictionary> departs=departDictionaryMapper.queryBy();
		List<Diaobodan> diaobodans=diaobodanMapper.queryByModel("all", "all", "all", "2016");		
		model.put("diaobodans", diaobodans);
		model.put("danjuhaos", danjuhaos);
		model.put("oils", oils);
		model.put("youkus", youkus);
		model.put("departs", departs);
		return "youliao_diaobo";
	}
	@PostMapping("youliao_diaobo/datas")
	@ResponseBody
	public QueryDataVO<Diaobodan> query(String departs,String oiltypes,String danjuhao,String gongyingdanwei){
		QueryDataVO<Diaobodan> maps=new QueryDataVO<Diaobodan>();
		List<Diaobodan> diaobodans=diaobodanMapper.queryByModel(gongyingdanwei,departs,danjuhao,"2016");		
		maps.setData(diaobodans);
		return maps;
	}
}
