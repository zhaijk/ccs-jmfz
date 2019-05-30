package com.derun.jczb.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derun.jczb.dao.DepartDictionaryMapper;
import com.derun.jczb.dao.SystemconfigMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Userbaseinfo;
@Component
public class SessionInfo {
	
	//private  static Logger logger=LoggerFactory.getLogger(SessionInfo.class);
	@Autowired
	private DepartDictionaryMapper departDictionaryMapper;
	@Autowired
	private SystemconfigMapper systemconfigMapper;
	
	public String getDepartmentCode() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();
		//System.out.println(obj.toString());
		if(obj.getDanwei().equals("本单位")) {
			String code=systemconfigMapper.queyZDInfo().getDanwei_code().substring(0,4);
			//System.out.println("本单位部门代码......"+code);
			return code;
		}else {			
			//return systemconfigMapper.queyZDInfo().getDanweiCode();
			String code=obj.getDanwei().substring(0,4);
			//System.out.println("部门代码......"+code);
			return code;
		}
	}
	public Userbaseinfo getUserInfo() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();
		return obj;
	}
	public String getUsername() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();		
		return obj.getUsername();
	}	
	public String getDepartmentName() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();	
		if(obj.getDanwei().equals("本单位")) {
			return systemconfigMapper.queyZDInfo().getDanwei();
		}else {
			DeparDictionary depart=departDictionaryMapper.queryByCode(obj.getDanwei());
			return depart.getBumen();
		}
	}
	public String getRoleName() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();
		return obj.getPower();
	}
	public String getJieZhuanDate() {		
		return systemconfigMapper.queyJiezhuandate().substring(0,4);
	}
	public int getIntJieZhuanDate() {		
		return Integer.parseInt(systemconfigMapper.queyJiezhuandate().substring(0,4));
	}
}
