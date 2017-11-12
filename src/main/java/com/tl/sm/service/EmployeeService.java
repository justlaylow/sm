package com.tl.sm.service;

import java.util.List;

import com.tl.sm.pojo.Employee;

public interface EmployeeService {
	
	//查询所有员工
	public List<Employee> listEmp();
	
	//增加员工
	public String insertEmp(Employee employee);
	
	//删除员工
	public String deleteEmp(Integer id);
	
	//修改员工信息
	public String updateEmp(Employee employee);
	
	//模糊查询
	public List<Employee> listEmpBlurry(String name,Integer id,String oa);
}
