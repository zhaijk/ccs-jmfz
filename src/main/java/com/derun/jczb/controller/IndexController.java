package com.derun.jczb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.derun.jczb.dao.ResoureUrlMapper;
//import com.derun.jczb.dao.UserInfoMapper;
import com.derun.jczb.model.ResourceUrl;
import com.derun.jczb.model.UserInfoIccard;
import com.derun.jczb.util.SessionInfo;

/*import com.derun.jczb.dao.ResoureUrlMapper;
import com.derun.jczb.dao.UserInfoMapper;
import com.derun.jczb.model.ResourceUrl;
import com.derun.jczb.model.UserInfoIccard;*/


@Controller
public class IndexController {

	@GetMapping("")
	public String index() {
		return "login_page";
	}
	@Autowired
	private ResoureUrlMapper resoureUrlMapper;
//	@Autowired
//	private UserInfoMapper userInfoMapper;
	@Autowired
	private SessionInfo session;
	
	@PostMapping("login")
	public String login(UserInfoIccard user) {		
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLogin_name(), user.getLogin_password());
        currentUser.login(token);        
		return "redirect:welcome";
	}
	@GetMapping("welcome")
	public String welcome(ModelMap model) {
		List<ResourceUrl> resourceUrls=resoureUrlMapper.queryLevename();
		Map<String ,List<ResourceUrl>> menus=new LinkedHashMap<String ,List<ResourceUrl>>();
		for(ResourceUrl res: resourceUrls) {
			List<ResourceUrl> objs=resoureUrlMapper.queryResource(res.getLevelname(),session.getUserInfo().getPower());
			if(objs.size()==0)
				menus.remove(res.getLevelname());
			else
				menus.put(res.getLevelname(), objs);
		}
		model.put("menus", menus);		
		model.put("departmentname", session.getDepartmentName());
		model.put("rolename", session.getUserInfo().getPower());
		model.put("username", session.getUserInfo().getLoginname());
		return "main";
	}
	@GetMapping("not_login")
	public String notLogin() {
		return "not_login";
	}
	@GetMapping("not_role")
	public String notRole() {
		return "not_role";
	}
}
