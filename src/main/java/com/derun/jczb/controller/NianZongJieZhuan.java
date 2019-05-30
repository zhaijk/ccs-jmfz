package com.derun.jczb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * info 年终结转
 * @author Administrator
 *
 */
@Controller
public class NianZongJieZhuan {

	@GetMapping("nianzongjiezhuan.htm")
	public String init() {
		
		return "nianzongjiezhuan";
	}
}
