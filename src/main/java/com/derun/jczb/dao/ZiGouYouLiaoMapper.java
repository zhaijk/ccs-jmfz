package com.derun.jczb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.ZiGouYouLiao;

public interface ZiGouYouLiaoMapper {

	@Select("select * from zhigouyouliao")
	List<ZiGouYouLiao> queryAll();
}
