package com.derun.jczb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.jczb.dao.QuotaMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YoukuDictionary;
//import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Zhibiaorecord;
import com.derun.jczb.service.CommitService;
import com.derun.jczb.util.DataTypeConverter;
import com.derun.jczb.util.SessionInfo;
/**
 * info 
 * @author Administrator
 *
 */
@Controller
public class QuotaFixedController {
	
	@Autowired
	private QuotaMapper quotaMapper;
	@Autowired
	private SessionInfo sessionInfo;
	@Autowired
	private CommitService commitService;
	
	@GetMapping("quota_fixed_managment.htm")
	public String  init(ModelMap model) {
		String departmentCode=sessionInfo.getDepartmentCode();
		int  niandu=sessionInfo.getIntJieZhuanDate();
		//上级调拨
		Zhibiaorecord sjdb=quotaMapper.queryBy(1, niandu,departmentCode);
		//上级调整
		Zhibiaorecord sjtz=quotaMapper.queryBy(3, niandu,departmentCode);
		//已分配合计
		Zhibiaorecord bjyfphj=quotaMapper.queryBy(2, niandu,departmentCode);
		//本级已记账
		List<Zhibiaorecord> bjyfp=quotaMapper.queryObjsBy(4,niandu,1,departmentCode);		
		//放置对象
		//List<YoukuDictionary> jfjyoukus=commitService.queryByYouku(1, 1);
		//List<YoukuDictionary> wjyoukus=commitService.queryByYouku(2, 1);
		List<DeparDictionary> departs=commitService.queryDepartInfo();
		//List<OilDictionary> oils=commitService.queryByOil("1");
		//model.put("jfjyoukus", jfjyoukus);
		//model.put("wjyoukus", wjyoukus);
		model.put("departs", departs);
		//model.put("oils", oils);
		model.put("sjdb", sjdb);
		model.put("sjtz", sjtz);
		model.put("bjyfphj", bjyfphj);
		model.put("bjyfp", bjyfp);
		return "quota_fixed_managment";
	}
	@GetMapping("quota_fixed_managment/edit")
	@ResponseBody
	public String edit(String action,Zhibiaorecord obj) {
		//String niandu="2016";
		int niandu=sessionInfo.getIntJieZhuanDate();
		int result=0;
		//System.out.println(obj.getDanwei_name());
		obj.setNiandu(niandu);
		switch(action) {
			case "accounting":
				result=quotaMapper.updateOne(obj);
				break;
			case "delete":
				result=quotaMapper.deleteOne(obj);
				break;
			case "assign":				
				//判断上级分配 与分配合计差值 为分配上限
				obj.setBiaozhi(0l);
				obj.setLeixing(2l);//本级分配
				obj.setJizhang(0l);//未记账				
				obj.setJf_xiaoji(obj.getJfTotal());//计算经费小计
				obj.setYl_xiaoji(obj.getYlTotal());//计算油料小计
				obj.setNiandu(2016);
				obj.setFenpeidate(DataTypeConverter.getDate());
				result=quotaMapper.insertOne(obj);
				break;	
		}
		return result==1?"sucess":"failure";
	}
}
