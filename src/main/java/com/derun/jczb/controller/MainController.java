package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derun.jczb.dao.CardTradeDAO;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DanweiShouzhiRecordMapper;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.DanweiShouzhiRecord;
import com.github.pagehelper.PageInfo;

//import reactor.core.publisher.Mono;

@RestController
public class MainController {

	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired
	private CardTradeDAO dao;
	@Autowired
	private DanweiShouzhiRecordMapper danweiShouzhiRecordMapper;
	
	@GetMapping("/getcardtrade")
	public List<CardTrade> index() {
		return cardTradeMapper.queryALL();
	}
	@GetMapping("/getcounter")
	public int counter() {
		return cardTradeMapper.queryCount();
	}	
	@GetMapping("/getDanweiShouzhi")
	public List<DanweiShouzhiRecord> queryDanweiShouzhiRecord() {
		return danweiShouzhiRecordMapper.queryALL();
	}	
	@GetMapping("/getrecord")
	public PageInfo<CardTrade> page(int start,int page) {
		return dao.pageQuery(start, page);
	}
	@GetMapping("/geterror")
	public String page() {
		return "hello";
	}
}
