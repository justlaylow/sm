package com.tl.sm.mapper;

import com.tl.sm.pojo.AllInfo;

public interface AllInfoMapper {
	//更新
	int updateAllByPrimaryKeySelective(AllInfo allInfo);
	
	//删除
	int deleteEmp(String salId);
	int deleteCal(String calId);
	int deleteIns(String insId);
}
