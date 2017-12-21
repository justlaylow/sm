package com.tl.sm.mapper;

import com.tl.sm.pojo.AllInfo;

public interface AllInfoMapper {
	//更新
	int updateAllByPrimaryKeyEmp(AllInfo allInfo);
	int updateAllByPrimaryKeyCal(AllInfo allInfo);
	int updateAllByPrimaryKeyIns(AllInfo allInfo);
	
	
	//查询最大月份
    String selectMaxDate();
	
	//删除
	int deleteEmp(String salId);
	int deleteCal(String calId);
	int deleteIns(String insId);
}
