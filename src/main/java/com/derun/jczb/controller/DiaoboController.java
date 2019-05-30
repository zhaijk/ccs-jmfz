package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.ZhuandaigongMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.QueryDataVO;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.model.Zhuandaigong;
import com.derun.jczb.model.ZhuandaigongTotal;
import com.derun.jczb.service.CommitService;
//import com.derun.util.DataTypeConverter;
/**
 *     油料调拨 解放军 油库  武警油库 转代供  
 * @author Administrator
 *
 */
@Controller
public class DiaoboController {

	@Autowired
	private CommitService commitService;
	
	@RequestMapping("youliao_diaobo.htm")
	public String init(ModelMap model) {
		List<YoukuDictionary> jfjyoukus=commitService.queryByYouku(1, 1);
		List<YoukuDictionary> wjyoukus=commitService.queryByYouku(2, 1);
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
	public  String edit(String edit,String jfjyoukus,String shougongdanwei,String wjyoukus,String kaidanriqi,String memo,@RequestParam("oils[]") Integer[] oils){	
		Diaobodan diaobodan=new Diaobodan();
		diaobodan.setGongyingyouku(jfjyoukus);
		if(wjyoukus.equals("all")) {
			diaobodan.setLeixing(4l);
			diaobodan.setShougongdanwei(shougongdanwei);
		}else {
			diaobodan.setLeixing(5l);
			diaobodan.setShougongdanwei(wjyoukus);
		}
		diaobodan.setKaidanriqi(kaidanriqi);
		//System.out.println(jfjyoukus+" "+shougongdanwei+" "+wjyoukus+" "+dateselect+" "+memo+" "+oils[oils.length-1]);
		commitService.insertDiaoboDWWJ(diaobodan,oils);
		return "success";
	}
	@RequestMapping("wjyouliao_diaobo.htm")
	public String init_wj(ModelMap model) {
		List<YoukuDictionary> wjyoukus=commitService.queryByYouku(2, 2);
		List<DeparDictionary> departs=commitService.queryDepartInfo();
		List<OilDictionary> oils=commitService.queryByOil("1");
		model.put("wjyoukus", wjyoukus);
		model.put("departs", departs);
		model.put("oils", oils);
		return "wjyouliao_diaobo";
	}
	@PostMapping("wjyouliao_diaobo/datas")
	@ResponseBody
	public QueryDataVO<Diaobodan> query_wj(String wjyoukus,String shougongdanwei){
		QueryDataVO<Diaobodan> maps=new QueryDataVO<Diaobodan>();
		List<Diaobodan> objs=commitService.queryDiaoboWjIncomePayment(wjyoukus,shougongdanwei, "2016");
		maps.setData(objs);
		return maps;
	}
	@PostMapping("wjyouliao_diaobo/edit")
	@ResponseBody	
	public  String edit_wj(String edit,String wjyoukus,String shougongdanwei,String kaidanriqi,String memo,@RequestParam("oils[]") Integer[] oils){	
		Diaobodan diaobodan=new Diaobodan();
		diaobodan.setGongyingyouku(wjyoukus);
		diaobodan.setLeixing(6l);
		diaobodan.setShougongdanwei(shougongdanwei);		
		diaobodan.setKaidanriqi(kaidanriqi);
		diaobodan.setBeizhu(memo);
		//System.out.println(wjyoukus+" "+shougongdanwei+" "+kaidanriqi+" "+memo+" "+oils[oils.length-1]);
		commitService.insertDiaoboDWWJ(diaobodan,oils);
		return "success";
	}
	@Autowired 
	private ZhuandaigongMapper zhuandaigongMapper;
	@RequestMapping("zdgyouliao_diaobo.htm")
	public String init_zdg(ModelMap model) {
		List<YoukuDictionary> wjyoukus=commitService.queryByYouku(2, 2);
		List<DeparDictionary> departs=commitService.queryDepartInfo();
		List<OilDictionary> oils=commitService.queryByOil("1");
		model.put("wjyoukus", wjyoukus);
		model.put("departs", departs);
		model.put("oils", oils);
		return "zdgyouliao_diaobo";
	}
	@Autowired
	private CardTradeMapper cardTradeMapper;
	
	@PostMapping("zdgyouliao_diaobo/datas")
	@ResponseBody
	public QueryDataVO<ZhuandaigongTotal> query_zdg(){
		QueryDataVO<ZhuandaigongTotal> maps=new QueryDataVO<ZhuandaigongTotal>();
		List<ZhuandaigongTotal> objssz=zhuandaigongMapper.querySumBy(4,2011);
		List<ZhuandaigongTotal> objsjyl=cardTradeMapper.queryZdgSumBy("2015-12-26","2016-12-25");
		for(ZhuandaigongTotal obj:objssz) {
			for(ZhuandaigongTotal jyl:objsjyl) {
				if(jyl.getCode().equals(obj.getCode())) {
					obj.setJyl(jyl.getJyl());
				}
			}
			obj.setTotal(obj.getJz()+obj.getPz()-obj.getJyl());
		}
		maps.setData(objssz);
		return maps;
	}
	@PostMapping("zdgyouliao_diaobo/edit")
	@ResponseBody	
	public  String edit_zdg(Zhuandaigong obj){	
		/*obj.setNiandu(DataTypeConverter.getIntYear());
		obj.setLeixing(4l);
		obj.setRiqi(DataTypeConverter.getDate());
		obj.setWenjianhao("测试");
		zhuandaigongMapper.insertOne(obj);*/
		commitService.saveZdg(obj);
		return "success";
	}
	@PostMapping("zdgyouliao_total/datas")
	@ResponseBody	
	public  QueryDataVO<Zhuandaigong> query_zdg_total(String sg_danwei,String sg_danwei_text){
		QueryDataVO<Zhuandaigong> maps=new QueryDataVO<Zhuandaigong>();
		List<Zhuandaigong> objs=zhuandaigongMapper.queryTotalSgBy(sg_danwei, 2011);
		for(Zhuandaigong obj:objs) {
			obj.setSg_danwei(sg_danwei_text);
		}
		maps.setData(objs);
		return maps;
	}
}
