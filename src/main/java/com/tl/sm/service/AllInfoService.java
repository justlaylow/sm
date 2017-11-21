package com.tl.sm.service;

import com.tl.sm.pojo.AllInfo;

public interface AllInfoService {
	//更新
	public String AllUpdate(AllInfo allInfo);
	
	//删除
	public String deleteAll(String calId);
}
