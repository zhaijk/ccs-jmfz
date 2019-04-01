package com.derun.jczb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.derun.jczb.model.CardTrade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository
@CacheConfig(cacheNames="card_trade")
public class CardTradeDAO {

	@Autowired 
	private CardTradeMapper mapper;
	
	@Cacheable
	public PageInfo<CardTrade> pageQuery(int start,int page){
		PageHelper.startPage(start, page);
		List<CardTrade> objs=mapper.queryALL();
		PageInfo<CardTrade> pageInfo = new PageInfo<>(objs);
		return pageInfo;		
	}
}
