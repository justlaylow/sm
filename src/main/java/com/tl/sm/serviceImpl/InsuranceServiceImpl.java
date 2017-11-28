package com.tl.sm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	@Resource
	private InsuranceMapper insuranceMapper;

	//查询所有
	public List<Insurance> listIns() {
		List<Insurance> listIns = insuranceMapper.listIns();
		return listIns;
	}

	//模糊查询
	public List<Insurance> listInsBlurry(String insId,String insName) {
		List<Insurance> listInsBlurry = insuranceMapper.listInsBlurry(insId, insName);
		return listInsBlurry;
	}

	//更新
	public String updateIns(Insurance insurance) {
		String message = "";
		int i = insuranceMapper.updateByPrimaryKey(insurance);
		if(i>0) {
			message = "更新成功";
		}else {
			message = "更新失败";
		}
		return message;
	}

	//删除
	public String deleteIns(Integer insId) {
		String message = "";
		int i = insuranceMapper.deleteByPrimaryKey(insId);
		if(i>0) {
			message = "删除成功";
		}else {
			message = "删除失败";
		}
		return message;
	}

	//新增
	public String insertIns(Insurance insurance) {
		String message = "";
		int i = insuranceMapper.insert(insurance);
		if(i>0) {
			message = "添加成功";
		}else {
			message = "添加失败";
		}
		return message;
	}

	//批量更新
	public String updateBatch(List<Insurance> list) {
		String message = "";
		int i = insuranceMapper.updateBatch(list);
		if(i>0) {
			message = "修改成功";
		}else {
			message = "修改失败";
		}
		return message;
	}
	
}
