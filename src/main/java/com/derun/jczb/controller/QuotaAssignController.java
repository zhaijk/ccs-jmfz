package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.QuotaMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Zhibiaorecord;
import com.derun.jczb.util.DataTypeConverter;
import com.derun.jczb.util.SessionInfo;
/**
 * info 决策部分 指标分配
 * @author Administrator
 *
 */
@Controller
public class QuotaAssignController {
	
	@Autowired
	private QuotaMapper quotaMapper;
	@Autowired
	private SessionInfo sessioninfo;
	@GetMapping("quota_assign_managment.htm")
	public String  init(ModelMap model) {
//		String departmentCode="090000000000";
		String departmentCode=sessioninfo.getDepartmentCode();
		int jiezhuanDate=Integer.parseInt(sessioninfo.getJieZhuanDate());
//		String niandu="2016";
		//上级调拨
		Zhibiaorecord sjdb=quotaMapper.queryBy(1, jiezhuanDate,departmentCode);
		//上级调整
		Zhibiaorecord sjtz=quotaMapper.queryBy(3, jiezhuanDate,departmentCode);
		//已分配合计
		Zhibiaorecord bjyfphj=quotaMapper.queryBy(2, jiezhuanDate,departmentCode);
		//本级已分配
		List<Zhibiaorecord> bjyfp=quotaMapper.queryLstBy(2,jiezhuanDate,departmentCode);
		//本级已分配
		List<DeparDictionary> bjwfp=quotaMapper.queryDepartmentBy(2,jiezhuanDate);
		//放置对象
		model.put("sjdb", sjdb);
		model.put("sjtz", sjtz);
		model.put("bjyfphj", bjyfphj);
		model.put("bjyfp", bjyfp);
		model.put("bjwfp", bjwfp);
		return "quota_assign_managment";
	}
	@GetMapping("quota_assign_managment/edit")
	@ResponseBody
	public String edit(String action,Zhibiaorecord obj) {
		String strDate=sessioninfo.getJieZhuanDate();
		int jiezhuanDate=Integer.parseInt(strDate);
		//String niandu="2016";
		int result=0;
		//System.out.println(obj.getDanwei_name());
		obj.setNiandu(jiezhuanDate);
		switch(action) {
			case "accounting":
				//记账
				obj.setJizhang(1l);
				obj.setWenjianhao("");
				obj.setJzdate(strDate);
				result=quotaMapper.updateOne(obj);
				break;
			case "delete":
				//删除记账数据
				result=quotaMapper.deleteOne(obj);
				break;
			case "assign":				
				//判断上级分配 与分配合计差值 为分配上限
				obj.setBiaozhi(0l);
				obj.setLeixing(2l);//本级分配
				obj.setJizhang(0l);//未记账				
				obj.setJf_xiaoji(obj.getJfTotal());//计算经费小计
				obj.setYl_xiaoji(obj.getYlTotal());//计算油料小计
				obj.setNiandu(jiezhuanDate);				
				obj.setFenpeidate(DataTypeConverter.getDate());				
				result=quotaMapper.insertOne(obj);
				break;	
		}
		return result==1?"sucess":"failure";
	}
}
