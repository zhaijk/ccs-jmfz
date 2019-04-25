package com.derun.jczb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *   卡操作
 * @author Administrator
 *
 */
@Controller
public class CardOperation {

	@GetMapping("card_operation_init.htm")
	public String init() {
		return "card_operation_init";
	}
	@GetMapping("card_operation_quota.htm")
	public String quota() {
		return "card_operation_quota";
	}
}
