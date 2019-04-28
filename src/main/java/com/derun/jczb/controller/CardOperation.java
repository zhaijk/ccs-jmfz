package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.JunquDictionary;

/**
 *     info:卡操作 清卡 初始化 有效  有效期 更换油品 更换车号  
 *     info:卡信息修改-修改数据库信息 固定指标 补助指标 限额指标
 *     info:解灰  断电解灰？
 *     info:圈存 
 *     info:卡发行 实物 价拨 机动卡(实物) 
 *     info:卡停用(作废 挂失->解挂 黑名单 白名单  灰名单) 补发 作废(清卡-重新初始化)
 *     info: 
 * @author Administrator
 *
 */
@Controller
public class CardOperation {
	
	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired
	private CardProvideMapper cardProvideMapper;
	
	@GetMapping("card_operation_init.htm")
	public String init() {
		return "card_operation_init";
	}
	@GetMapping("card_operation_quota.htm")
	public String quota() {
		return "card_operation_quota";
	}
	@PostMapping("query_gray_card_trade")
	@ResponseBody
	public CardTrade queryGrayRecord(CardTrade obj) {		
		//System.out.println(obj);
		CardTrade cardTradeGray=cardTradeMapper.queryGrayTrade(obj);
		return cardTradeGray;		
	}
	@PostMapping("update_gray_card_trade")
	@ResponseBody
	public String updateGrayRecord(CardTrade obj) {		
		//System.out.println(obj);
		int result=cardTradeMapper.updateGrayTrade(obj);
		return result==1? "操作成功" : "操作失败" ;		
	}
	@PostMapping("query_quota_card_trade/datas")
	@ResponseBody
	public DataTableDO<CardProvideReport> queryQuotaRecord(CardProvideReport obj) {	
		System.out.println(obj.getCarcode()+" "+obj.getSendflag());
		DataTableDO<CardProvideReport>  dataTableDO=new DataTableDO<CardProvideReport>();
		List<CardProvideReport> objs=cardProvideMapper.queryQuotaByCardcodeSendFlag(obj);
		dataTableDO.setData(objs);
		return dataTableDO;		
	}
	@PostMapping("query_quota_card_trade/value")
	@ResponseBody
	public CardProvideReport queryQuotaRecordTotal(CardProvideReport obj) {	
		//System.out.println(obj.getCarcode()+" "+obj.getSendflag());
		//DataTableDO<CardProvideReport>  dataTableDO=new DataTableDO<CardProvideReport>();
		CardProvideReport objr=cardProvideMapper.queryQuotaTotalByCardcodeSendFlag(obj);
        return objr;		
	}
	@PostMapping("update_quota_card_trade")
	@ResponseBody
	public String updateQuotaRecord(CardProvideReport obj) {		
		//System.out.println(obj);
		int result=cardProvideMapper.updateOne(obj);
		return result==1? "操作成功" : "操作失败" ;		
	}
}
