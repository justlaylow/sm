package com.tl.sm.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;

public interface EmployeeService {
	
	//查询所有员工
	public List<Employee> listEmp();
	
	//查询部门
	public List<Department> listDep();
	
	//查询所有员工和保险
	public List<Employee> listInner();
	
	//增加员工
	public String insertEmp(Employee employee);
	
	//删除员工
	public String deleteEmp(String id);
	
	//修改员工信息
	public String updateEmp(Employee employee);
	
	//模糊查询
	public List<Employee> listEmpBlurry(String name,String id,String oa,String name2,String id2,String oa2);
	
	//查询员工，保险，工资信息
	public List<Employee> listAll(String calDate,String salId);
	
}
