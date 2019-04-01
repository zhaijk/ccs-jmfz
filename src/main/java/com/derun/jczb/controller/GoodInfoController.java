package com.derun.jczb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodInfoController {

	@GetMapping("goodsinfo")
	public String  init() {
		return "good11sinfo";
	}
}
