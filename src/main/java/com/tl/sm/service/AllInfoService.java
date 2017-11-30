package com.tl.sm.service;

import com.tl.sm.pojo.AllInfo;

public interface AllInfoService {
	//更新
	public String AllUpdate(AllInfo allInfo);
	
	//删除
	public String deleteAll(String calId);
	
	//查询最大工资日期，用于修改，之前的日期无法修改
	public String maxMonth();
}
