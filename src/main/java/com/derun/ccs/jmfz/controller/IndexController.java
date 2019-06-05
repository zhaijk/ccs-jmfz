package com.derun.ccs.jmfz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.derun.ccs.jmfz.dao.BXGSMapper;
import com.derun.ccs.jmfz.dao.CcsHdXxMapper;
import com.derun.ccs.jmfz.dao.JMDMMapper;
import com.derun.ccs.jmfz.dao.JMLXMapper;
import com.derun.ccs.jmfz.dao.UserMapper;
import com.derun.ccs.jmfz.model.UserInfo;

@Controller
public class IndexController {

	@Autowired
	private BXGSMapper bXGSMapper;
	@Autowired
	private JMDMMapper jMDMMapper;
	@Autowired
	private JMLXMapper jMLXMapper;
	@Autowired
	private CcsHdXxMapper ccsHdXxMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	@GetMapping({"/",""})
	public String init() {
		return "login";
	}
	@PostMapping("login")
	public String login(String loginname,String loginpassword) {
		List<UserInfo> result=userMapper.querBy(loginname,loginpassword);
		if(result.size()==0) {
			return "loginfailure";
		}
		return "redirect:welcome";
	}
	@GetMapping("welcome")
	public String mainpage(ModelMap model) {
		model.put("bxgs_counter", bXGSMapper.queryCounter());
		model.put("jmdm_counter", jMDMMapper.queryCounter());
		model.put("jmlx_counter", jMLXMapper.queryCounter());
		model.put("rksl_counter", ccsHdXxMapper.queryCounter());
		return "main";
	}
	@GetMapping("loading")
	public String loading() {
		return "loading";
	}
	@GetMapping("zhengce.htm")
	public String zhengce() {
		return "zhengce";
	}
}
