package com.derun.ccs.jmfz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.ccs.jmfz.dao.UserMapper;
import com.derun.ccs.jmfz.model.UserInfo;

/**
 * info 用户信息管理
 * @author Administrator
 *
 */
@Controller
public class UserInfoController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("userinfo.htm")
	public String init() {
		return "userinfo";
	}
	@GetMapping("userinfo/datas")
	@ResponseBody
	public DataTableDO<UserInfo> query() {
		DataTableDO<UserInfo> dataTableDO=new DataTableDO<UserInfo>();
		dataTableDO.setData(userMapper.queryALL());
		return dataTableDO;
	}
}
