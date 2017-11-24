package com.tl.sm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.DepartmentMapper;
import com.tl.sm.pojo.Department;
import com.tl.sm.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;

	// 新增部门
	public String addDep(Department department) {
		int res = departmentMapper.insert(department);
		String message = "";
		if (res > 0) {
			message = "添加成功";
		} else {
			message = "添加失败";
		}
		return message;
	}

	// 修改部门信息
	public String updateDep(Department department) {
		String depN ="";
		List<Department> depName = departmentMapper.DepName(department.getId());
		for(Department c:depName) {
			depN = c.getDepName();
		}
		int res = departmentMapper.updateByPrimaryKeySelective(department);
		int emp = departmentMapper.updateEmpDep(department.getDepName(), depN);
		String message = "";
		if (res > 0 & emp>0) {
			message = "修改成功";
		} else {
			message = "修改失败";
		}
		return message;
	}

	// 删除部门
	public String deleteDep(Integer id) {
		int res = departmentMapper.deleteByPrimaryKey(id);
		String message = "";
		if (res > 0) {
			message = "添加成功";
		} else {
			message = "添加失败";
		}
		return message;
	}
	
	//查询所有部门
	public List<Department> listAll(){
		List<Department> uList = departmentMapper.listAll();
		return uList;
	}

	//模糊查询
	@Override
	public List<Department> listByDep(String depId, String depName) {
		List<Department> blurryList = departmentMapper.listByDep(depId, depName);
		return blurryList;
	}
}
