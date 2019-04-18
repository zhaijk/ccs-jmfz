package com.derun.jczb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

	@GetMapping("")
	public String index() {
		return "login";
	}
	@PostMapping("welcome")
	public String main() {
		return "main";
	}
	@GetMapping("zm.htm")
	public String zm() {
		return "zm";
	}
	@GetMapping("zt.htm")
	public String zt() {
		return "zt";
	}
}
