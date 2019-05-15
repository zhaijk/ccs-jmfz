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
		String code=obj.getDanwei().substring(0,4);
		//logger.info("部门代码......"+code);
		return code;
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
		DeparDictionary depart=departDictionaryMapper.queryByCode(obj.getDanwei());
		return depart.getBumen();
	}
	public String getRoleName() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();
		return obj.getPower();
	}
	public String getJieZhuanDate() {		
		return systemconfigMapper.queyJiezhuandate();
	}
}
