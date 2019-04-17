package com.derun.jczb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.YoukuSunhaoMapper;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YouKuSunHao;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.service.CommitService;
import com.derun.util.DataTypeConverter;

/**
 *   油库损耗
 * @author Administrator
 *
 */
@Controller
public class YoukuShunhaoController {

	@Autowired 
	private CommitService commitService;
	@Autowired
	private YoukuSunhaoMapper youkuSunhaoMapper;
	
	@RequestMapping("youku_sunhao.htm")
	public String init(ModelMap model) {
		List<OilDictionary> oils=commitService.queryByOil("1");		
		List<YoukuDictionary> youkus=commitService.queryByYouku(2, 2);
		model.put("oils", oils);
		model.put("youkus", youkus);
		return "youku_sunhao";
	}
	@PostMapping("youku_sunhao/datas")
	@ResponseBody
	public QueryDataVO<YouKuSunHao> query(String gongyingyouku){
		QueryDataVO<YouKuSunHao> maps=new QueryDataVO<YouKuSunHao>();
		List<YouKuSunHao>  youkusunhaos=commitService.queryYoukuSunhao(gongyingyouku,"2016");
		
		maps.setData(youkusunhaos);
		return maps;
	}
	@PostMapping("youku_sunhao/edit")
	@ResponseBody
	public  String edit(YouKuSunHao shunhao,@RequestParam("oils[]") Integer[] oils){
		int  result=0;
		int  counter=0;
		List<OilDictionary> oilinfos=commitService.queryByOil("1");
		for(OilDictionary oil:oilinfos) {
			shunhao.setDanjuhao(ykshDJH(shunhao.getYouku()));
			shunhao.setNiandu(DataTypeConverter.getIntYear());
			shunhao.setOil(oil.getCode().intValue());
			//shunhao.setYouku(youku);
			shunhao.setRiqi(DataTypeConverter.getDate());
			shunhao.setYoupin(oils[counter]);	
			if(oils[counter]>0)
				result=youkuSunhaoMapper.insertOne(shunhao);
			counter++;
		}
		return result==1?"success":"failure";
	}
	private String ykshDJH(String youku) {		
		StringBuilder  idStr=new StringBuilder();
		String wenjianhao=youkuSunhaoMapper.queryMaxDjhBy(DataTypeConverter.getIntYear());		
		if(null==wenjianhao) {
			idStr.append("耗");
			idStr.append(DataTypeConverter.getIntYear()%100);
			idStr.append(youku.substring(0, 2));
			idStr.append("0000001");
			return idStr.toString();
		}
		int counter=Integer.parseInt(wenjianhao.substring(5,12))+1;
		idStr.append(wenjianhao.substring(0,5));
		idStr.append(String.format("%04d", counter));				
		return idStr.toString();
	}
}
