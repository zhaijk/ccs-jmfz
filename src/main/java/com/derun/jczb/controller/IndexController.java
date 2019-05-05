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
import com.derun.jczb.model.ResourceUrl;
import com.derun.jczb.model.UserInfo;

@Controller
public class IndexController {

	@GetMapping("")
	public String index() {
		return "login";
	}
	@Autowired
	private ResoureUrlMapper resoureUrlMapper;
	@PostMapping("welcome")
	public String main(ModelMap model,UserInfo user) {
		/*System.out.println(user.getLoginname()+" "+user.getUsername());
		//JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        
		//根据用户登录权限加载菜单
		List<ResourceUrl> resourceUrls=resoureUrlMapper.queryLevename();
		Map<String ,List<ResourceUrl>> menus=new LinkedHashMap<String ,List<ResourceUrl>>();
		for(ResourceUrl obj: resourceUrls) {
			List<ResourceUrl> objs=resoureUrlMapper.queryResource(obj.getLevelname());
			menus.put(obj.getLevelname(), objs);
		}
		model.put("menus", menus);*/
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
