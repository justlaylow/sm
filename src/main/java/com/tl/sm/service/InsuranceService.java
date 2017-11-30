package com.tl.sm.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	
	//批量导入更新保险获得list
	public List<Insurance> importExcelInfo(InputStream in, MultipartFile file,Integer adminId) throws Exception;
	//批量导入更新
	public String importBatch(List<Insurance> list);
}
