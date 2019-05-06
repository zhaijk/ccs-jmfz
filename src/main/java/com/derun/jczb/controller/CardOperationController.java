package com.derun.jczb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CarInfoMapper;
import com.derun.jczb.dao.CardMainMapper;
import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.model.CarInfo;
import com.derun.jczb.model.CardMain;
import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.DepartmentInfo;
//import com.derun.jczb.model.JunquDictionary;
import com.derun.jczb.model.OilInfo;
import com.derun.util.DataTypeConverter;

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
public class CardOperationController {
	
	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired
	private CardProvideMapper cardProvideMapper;
	@Autowired
	private CardMainMapper cardMainMapper;
	@Autowired
	private CarInfoMapper carInfoMapper;
	@Autowired
	private DepartmentInfoMapper departInfoMapper;
	
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
	@GetMapping("card_operation_provide.htm")
	public String provide(ModelMap model) {		
		String departmentCode="09";
		
		List<OilInfo> oilInfos=oilInfoMapper.queryByOilInfo(departmentCode);
		List<CarInfo> carInfos=carInfoMapper.queryUnuseCar(departmentCode);
		List<DepartmentInfo> departInfos=departInfoMapper.queryByDepartmentCode(departmentCode);
		
		model.put("departInfos", departInfos);
		model.put("oilInfos",oilInfos);
		model.put("carInfos",carInfos);
		return "card_operation_provide";
	}
	@Autowired
	private OilInfoMapper oilInfoMapper;
	
	@GetMapping("card_operation_provide/datas")
	@ResponseBody
	public DataTableDO<CardMain> queryCardInfos() {
		String danwei="09";
		DataTableDO<CardMain>  dataTableDO=new DataTableDO<CardMain>();
		List<CardMain> objs=cardMainMapper.queryCardinfos(danwei);
		dataTableDO.setData(objs);
		return dataTableDO;		
	}
	@PostMapping("card_operation_provide/insert")
	@ResponseBody
	public String insertCardInfo(CardMain obj) {		
		obj.setCardcode(obj.getDepartmentCode().substring(0,6)+obj.getCardcode().substring(6, 12));
		obj.setStationid(obj.getDepartmentCode());
		obj.setCardstatus("正常");
		obj.setBuildDate(DataTypeConverter.getDate());
		obj.setOperator("测试");
		obj.setFillCardterm(DataTypeConverter.getDate(obj.getFillCardterm()));
		int result=cardMainMapper.insertOne(obj);
		return result==1?"success":"failure";
	}
	@GetMapping("card_operation_modify.htm")
	public String modify(ModelMap model) {		
		String departmentCode="09";
		
		List<OilInfo> oilInfos=oilInfoMapper.queryByOilInfo(departmentCode);
		List<CarInfo> carInfos=carInfoMapper.queryALLByDepartmentCode("");
		List<DepartmentInfo> departInfos=departInfoMapper.queryByDepartmentCode(departmentCode);
		
		model.put("departInfos", departInfos);
		model.put("oilInfos",oilInfos);
		model.put("carInfos",carInfos);
		return "card_operation_modify";
	}	
	@PostMapping("card_operation_modify/getcardinfo")
	@ResponseBody
	public CardMain getCardInfo(CardMain obj) {
		CardMain result=cardMainMapper.queryOne(obj);		
		return result;
	}
	@PostMapping("card_operation_modify/update")
	@ResponseBody
	public String  updateCardInfo(CardMain obj,String flag) {
		int result=0;
		System.out.println(obj.toString());
		switch(flag) {
		case "carcode":
			result=cardMainMapper.updateCarcode(obj);
			break;
		case "oiltype":
			result=cardMainMapper.updateOiltype(obj);
			break;
		case "valid_date":
			result=cardMainMapper.updateValidDate(obj);
			break;
		case "quota_info":
			result=cardMainMapper.updateQuotaInfo(obj);
			break;
		}				
		return result==1?"success":"failure";
	}
}
