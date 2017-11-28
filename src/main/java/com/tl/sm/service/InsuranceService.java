package com.tl.sm.service;

import java.util.List;

import com.tl.sm.pojo.Insurance;

public interface InsuranceService {
	//查询所有
	public List<Insurance> listIns();
	
	//模糊查询
	public List<Insurance> listInsBlurry(String insId,String insName);
	
	//更新
	public String updateIns(Insurance insurance);
	
	//删除
	public String deleteIns(Integer insId);
	
	//新增
	public String insertIns(Insurance insurance);
	
	//批量更新
	public String updateBatch(List<Insurance> list);
	
}
