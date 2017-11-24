package com.tl.sm.service;

import java.util.List;

import com.tl.sm.pojo.Department;

public interface DepartmentService {
	//新增部门
	public String addDep(Department department);
	
	//查询所有
	List<Department> listAll();
	
	//修改部门
	public String updateDep(Department department);
	
	//删除部门
	public String deleteDep(Integer id);
	
	//模糊查询
	public List<Department> listByDep(String depId,String depName);
	
}
