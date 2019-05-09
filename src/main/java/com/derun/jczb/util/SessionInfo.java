package com.derun.jczb.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.derun.jczb.model.Userbaseinfo;
@Component
public class SessionInfo {
	
	private  static Logger logger=LoggerFactory.getLogger(SessionInfo.class);
	
	public String getDepartmentCode() {
		Subject subject = SecurityUtils.getSubject();
		Userbaseinfo obj=(Userbaseinfo) subject.getPrincipal();
		String code=obj.getDanwei().substring(0,4);
		logger.info("部门代码......"+code);
		return code;
	}
	
}
