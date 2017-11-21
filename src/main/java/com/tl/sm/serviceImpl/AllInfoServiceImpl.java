package com.tl.sm.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.AllInfoMapper;
import com.tl.sm.pojo.AllInfo;
import com.tl.sm.service.AllInfoService;

@Service
public class AllInfoServiceImpl implements AllInfoService{
	@Resource
	private AllInfoMapper allInfoMapper;
	
	public String AllUpdate(AllInfo allInfo) {
		String message = "";
		int i = allInfoMapper.updateAllByPrimaryKeySelective(allInfo);
		if(i>0) {
			message = "更新成功";
		}else {
			message = "更新失败";
		}
		return message;
	}

	public String deleteAll(String calId) {
		String message = "";
		int i = allInfoMapper.deleteEmp(calId);
		int j = allInfoMapper.deleteCal(calId);
		int x = allInfoMapper.deleteIns(calId);
		if(i>0&&j>0&&x>0) {
			message = "删除成功";
		}else {
			message = "删除失败";
		}
		return message;
	}

}
