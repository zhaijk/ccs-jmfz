package com.derun.jczb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		//根据用户登录权限加载菜单
		List<ResourceUrl> resourceUrls=resoureUrlMapper.queryLevename();
		Map<String ,List<ResourceUrl>> menus=new LinkedHashMap<String ,List<ResourceUrl>>();
		for(ResourceUrl obj: resourceUrls) {
			List<ResourceUrl> objs=resoureUrlMapper.queryResource(obj.getLevelname());
			menus.put(obj.getLevelname(), objs);
		}
		model.put("menus", menus);
		return "main";
	}
}
