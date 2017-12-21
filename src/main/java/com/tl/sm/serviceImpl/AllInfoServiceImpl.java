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
	
	//更新数据,联合三个表批量更新
	public String AllUpdate(AllInfo allInfo) {
		String message = "";
		int i = allInfoMapper.updateAllByPrimaryKeyEmp(allInfo);
		int j = allInfoMapper.updateAllByPrimaryKeyCal(allInfo);
		int x = allInfoMapper.updateAllByPrimaryKeyIns(allInfo);
		if(i>0&&j>0&&x>0) {
			message = "更新成功";
		}else {
			message = "更新失败";
		}
		return message;
	}

	//通过工号删除员工的信息,保险信息,工资信息
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

	//查询最大日期,用于修改操作,实现仅最大的月份能修改,之前的月份无法修改
	public String maxMonth() {
		String maxMonth = allInfoMapper.selectMaxDate();
		return maxMonth;
	}

}
